package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsCannon extends GameObject {
	protected double angle;
	protected int power;

	public AbsCannon(double angle, int power) {
		this.power = power;
        this.angle = angle;
	}

	public abstract void aimUp();
	public abstract void aimDown();
	
	public abstract void moveUp();
	public abstract void moveDown();

	public abstract void incPower();
	public abstract void decPower();
	
	public abstract List<AbsMissile> shoot();
	public abstract AbsMissile primitiveShoot();

	public abstract void toggleShootingMode();
	public abstract void setDoubleShootingMode();
	public abstract void setSingleShootingMode();

	public void accept(IVisitor visitor) {
        visitor.visitCannon(this);
	}

	public int getPower() {
		return this.power;
	}

	public double getAngle() {
		return this.angle;
	}
}
