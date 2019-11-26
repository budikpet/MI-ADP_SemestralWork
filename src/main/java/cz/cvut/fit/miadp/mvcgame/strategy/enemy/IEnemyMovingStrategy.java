package cz.cvut.fit.miadp.mvcgame.strategy.enemy;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

/**
 * Interface for missile movement strategies.
 */
public interface IEnemyMovingStrategy {

    void updatePosition(AbsEnemy enemy);

}