package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsGameInfo extends GameObject {
    protected IGameModel model;

    public AbsGameInfo(IGameModel model) {
        this.model = model;
    }

    public abstract String getText();

    public void accept(IVisitor visitor) {
        visitor.visitGameInfo(this);
    }

}
