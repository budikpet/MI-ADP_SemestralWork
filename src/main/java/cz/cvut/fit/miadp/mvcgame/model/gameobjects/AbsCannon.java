package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.state.ShootingModes;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsCannon extends GameObject {
	protected double angle;
	protected double power;
	protected ShootingModes mode;

	public AbsCannon(double angle, double power) {
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

	public void accept(IVisitor visitor) {
        visitor.visitCannon(this);
	}

	public void toggleShootingMode() {
		this.mode = this.mode.toggle();
	}

	// ================================================================================
    // Getters/Setters
    // ================================================================================

	public ShootingModes getShootingMode() {
		return this.mode;
	}

	public void setShootingMode(ShootingModes mode) {
		this.mode = mode;
	}

	public double getPower() {
		return this.power;
	}

	public double getAngle() {
		return this.angle;
	}
}
