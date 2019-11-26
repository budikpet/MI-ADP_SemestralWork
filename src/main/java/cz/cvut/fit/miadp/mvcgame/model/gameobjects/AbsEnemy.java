package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.DirectionEnum;
import cz.cvut.fit.miadp.mvcgame.model.TimelifeAwareGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsEnemy extends TimelifeAwareGameObject {
    private DirectionEnum direction = DirectionEnum.UP;
    
    public void accept(IVisitor visitor) {
        visitor.visitEnemy(this);
    }

    public abstract void move();

    public DirectionEnum getDirection() {
        return this.direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }
}
