package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.Position;

public class Cannon extends GameObject {

    public Cannon() {
        this.pos = new Position(MvcGameConfig.CANNON_INIT_X, MvcGameConfig.CANNON_INIT_Y);
    }

}
