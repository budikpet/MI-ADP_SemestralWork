package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.TimelifeAwareGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsMissile extends TimelifeAwareGameObject {
    protected Position startPos;
    protected double initPower;
    protected double initAngle;
    protected double offsetX;
    protected double offsetY;

    public AbsMissile(Position startPos, double initPower, double initAngle) {
        this.startPos = startPos;
        this.initPower = initPower;
        this.initAngle = initAngle;
        this.setX(startPos.getX());
        this.setY(startPos.getY());

        this.offsetX = 0;
        this.offsetY = 0;
    }
    
    public void accept(IVisitor visitor) {
        visitor.visitMissile(this);
    }

    public abstract void move();

    // ================================================================================
    // Getters/Setters
    // ================================================================================

    public Position getStartPos() {
        return startPos;
    }

    public double getInitAngle() {
        return initAngle;
    }

    public double getInitPower() {
        return initPower;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    public double getOffsetY() {
        return offsetY;
    }
}
