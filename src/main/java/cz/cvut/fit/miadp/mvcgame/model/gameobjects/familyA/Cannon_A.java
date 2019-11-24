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
		this.setX(MvcGameConfig.CANNON_INIT_X);
		this.setX((int) (MvcGameConfig.MAX_Y / 2));
		this.goFact = goFact;

		this.SINGLE_SHOOTING_MODE = new SingleShootingMode();
		this.DOUBLE_SHOOTING_MODE = new DoubleShootingMode();

		this.setSingleShootingMode();
	}

	public Float getVelocity() {
		return null;
	}

	public Float getAngle() {
		return null;
	}

	public void setVelocity(Float velocity) {

	}

	public void setAngle(Float angle) {

	}

	public void aimUp() {

	}

	public void aimDown() {

	}

	public void incPower() {

	}

	public void decPower() {

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
		AbsMissile m = this.goFact.createMissile();
		m.setX(this.getX());
		m.setY(this.getY());

		this.shootBatch.add(m);

		return m;
	}

	@Override
	public void toggleShootingMode() {

		this.mode.toggle(this);
	}

	@Override
	public void setDoubleShootingMode() {
		this.mode = this.DOUBLE_SHOOTING_MODE;
	}

	@Override
	public void setSingleShootingMode() {
		this.mode = this.SINGLE_SHOOTING_MODE;
	}

}
