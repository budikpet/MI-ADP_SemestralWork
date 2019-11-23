package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.TimelifeAwareGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsCollision extends TimelifeAwareGameObject
{

    public void accept(IVisitor visitor)
    {
        visitor.visitCollision(this);
    }



}

