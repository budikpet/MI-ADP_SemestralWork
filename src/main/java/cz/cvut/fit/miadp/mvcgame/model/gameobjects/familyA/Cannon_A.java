package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFac;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.state.ShootingModes;

public class Cannon_A extends AbsCannon {
	private IGameObjsFac goFact;
	private List<AbsMissile> shootBatch;

	public Cannon_A(IGameObjsFac goFact) {
		super(MvcGameConfig.INIT_ANGLE, MvcGameConfig.INIT_POWER);
		this.setX(MvcGameConfig.CANNON_INIT_X);
		this.setY((int) (MvcGameConfig.MAX_Y / 2));
		this.goFact = goFact;

		this.mode = ShootingModes.DOUBLE_SHOOT;
	}

	public void aimUp() {
		this.angle -= MvcGameConfig.ANGLE_STEP;
	}

	public void aimDown() {
		this.angle += MvcGameConfig.ANGLE_STEP;
	}

	public void incPower() {
		this.power += MvcGameConfig.POWER_STEP;
	}

	public void decPower() {
		this.power -= MvcGameConfig.POWER_STEP;
	}

	@Override
	public void moveUp() {
		this.move(0, -1 * MvcGameConfig.MOVE_STEP);
	}

	@Override
	public void moveDown() {
		this.move(0, MvcGameConfig.MOVE_STEP);
	}

	// ================================================================================
    // Shooting
    // ================================================================================

	@Override
	public List<AbsMissile> shoot() {

		this.shootBatch = new ArrayList<AbsMissile>();

		this.mode.getMode().shoot(this);

		return this.shootBatch;
	}

	public AbsMissile primitiveShoot() {
		AbsMissile m = this.goFact.createMissile(this);

		this.shootBatch.add(m);

		return m;
	}
}
