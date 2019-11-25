package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFac;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;

public class Cannon_A extends AbsCannon {

	private IShootingMode mode;

	private IShootingMode SINGLE_SHOOTING_MODE;
	private IShootingMode DOUBLE_SHOOTING_MODE;

	private IGameObjsFac goFact;
	private List<AbsMissile> shootBatch;

	public Cannon_A(IGameObjsFac goFact) {
		super(MvcGameConfig.INIT_ANGLE, MvcGameConfig.INIT_POWER);
		this.setX(MvcGameConfig.CANNON_INIT_X);
		this.setY((int) (MvcGameConfig.MAX_Y / 2));
		this.goFact = goFact;

		this.SINGLE_SHOOTING_MODE = new SingleShootingMode();
		this.DOUBLE_SHOOTING_MODE = new DoubleShootingMode();

		this.setSingleShootingMode();
		this.setDoubleShootingMode();
	}

	public void aimUp() {
		this.angle += MvcGameConfig.ANGLE_STEP;
	}

	public void aimDown() {
		this.angle -= MvcGameConfig.ANGLE_STEP;
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

	@Override
	public List<AbsMissile> shoot() {

		this.shootBatch = new ArrayList<AbsMissile>();

		this.mode.shoot(this);

		return this.shootBatch;
	}

	public AbsMissile primitiveShoot() {
		AbsMissile m = this.goFact.createMissile(this);

		this.shootBatch.add(m);

		return m;
	}

	@Override
	public void toggleShootingMode() {
		this.mode.toggle(this);
	}

	/**
	 * Used for setting the mode from IShootingMode.
	 */
	@Override
	public void setDoubleShootingMode() {
		this.mode = this.DOUBLE_SHOOTING_MODE;
	}

	/**
	 * Used for setting the mode from IShootingMode.
	 */
	@Override
	public void setSingleShootingMode() {
		this.mode = this.SINGLE_SHOOTING_MODE;
	}

}
