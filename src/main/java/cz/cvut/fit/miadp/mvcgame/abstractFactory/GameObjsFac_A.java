package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import java.util.Random;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Cannon_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Collision_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Enemy_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Missile_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.ModelInfo_A;
import cz.cvut.fit.miadp.mvcgame.strategy.GravityMoveStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

/**
 * Concrete implementation of AbstractFactory.
 */
public class GameObjsFac_A implements IGameObjsFac {

    private IMovingStrategy activeMovingStrategy = new GravityMoveStrategy();

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
        AbsEnemy enemy = new Enemy_A();
        enemy.setX(nextInt(MvcGameConfig.MAX_X - 30));
        enemy.setY(nextInt(MvcGameConfig.MAX_X - 30));
        
        return enemy;
    }

    private int nextInt(int maxValue) {
        Random rand = new Random();
        return rand.nextInt(MvcGameConfig.MAX_X - 30) + 30;
    }

    @Override
    public AbsMissile createMissile(AbsCannon cannon) {
        return new Missile_A(this.activeMovingStrategy, 
            cannon.getPosition(),
            cannon.getPower(),
            cannon.getAngle());
    }

    @Override
    public AbsModelInfo createModelInfo() {
        return new ModelInfo_A();
    }

}