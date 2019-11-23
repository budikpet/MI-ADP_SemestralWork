package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.*;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMoveStrategy;

public class GameObjsFac_A implements IGameObjsFac {

    private IMovingStrategy activeMovingStrategy = new SimpleMoveStrategy();



    @Override
    public AbsCannon createCannon() {
        return new Cannon_A(this);
    }

    @Override
    public AbsCollision createCollision() {
        return new Collision_A();
    }

    @Override
    public AbsEnemy createEnemy() {
        return new Enemy_A();
    }

    @Override
    public AbsMissile createMissile() {
        
        return new Missile_A(this.activeMovingStrategy);
    }

    @Override
    public AbsModelInfo createModelInfo() {
        return new ModelInfo_A();
    }

}