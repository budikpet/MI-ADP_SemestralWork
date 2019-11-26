package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import java.util.List;
import java.util.Random;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Cannon_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Collision_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Enemy_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.GameInfo_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Missile_A;
import cz.cvut.fit.miadp.mvcgame.strategy.enemy.EnemyMovementStrategies;
import cz.cvut.fit.miadp.mvcgame.strategy.enemy.IEnemyMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.missile.GravityMissileMoveStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.missile.IMissileMovingStrategy;

/**
 * Concrete implementation of AbstractFactory.
 */
public class GameObjsFac_A implements IGameObjsFac {

    private final IMissileMovingStrategy activeMovingStrategy = new GravityMissileMoveStrategy();

    @Override
    public AbsCannon createCannon() {
        return new Cannon_A(this);
    }

    @Override
    public AbsCollision createCollision(final Position pos) {
        return new Collision_A(pos);
    }

    @Override
    public AbsEnemy createEnemy() {
        final AbsEnemy enemy = new Enemy_A(getRandomStrategy());
        enemy.setX(nextInt(MvcGameConfig.MAX_X - 30));
        enemy.setY(nextInt(MvcGameConfig.MAX_X - 30));
        
        return enemy;
    }

    private IEnemyMovingStrategy getRandomStrategy() {
        Random rand = new Random();
        List<EnemyMovementStrategies> strategies = EnemyMovementStrategies.getValues();
        int index = rand.nextInt(strategies.size());

        return strategies.get(index).getStrategy();
    }

    private int nextInt(final int maxValue) {
        final Random rand = new Random();
        return rand.nextInt(MvcGameConfig.MAX_X - 30) + 30;
    }

    @Override
    public AbsMissile createMissile(final AbsCannon cannon) {
        return new Missile_A(this.activeMovingStrategy, 
            cannon.getPosition(),
            cannon.getPower(),
            cannon.getAngle());
    }

    @Override
    public AbsGameInfo createGameInfo(final IGameModel model) {
        return new GameInfo_A(model);
    }

}