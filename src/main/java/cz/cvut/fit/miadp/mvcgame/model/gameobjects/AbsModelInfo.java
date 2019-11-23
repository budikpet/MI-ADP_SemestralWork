package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsModelInfo extends GameObject
{
    public abstract String getText();

    public void accept(IVisitor visitor)
    {
        visitor.visitGameInfo(this);
    }

}
