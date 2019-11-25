package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.TimelifeAwareGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsMissile extends TimelifeAwareGameObject {
    protected Position startPos;
    protected double initPower;
    protected double initAngle;

    public AbsMissile(Position startPos) {
        this.startPos = startPos;
        //TODO: Redo
        this.initPower = MvcGameConfig.INIT_POWER / 20.0;
        this.initAngle = MvcGameConfig.INIT_ANGLE;
        this.setX(startPos.getX());
        this.setY(startPos.getY());
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
}
