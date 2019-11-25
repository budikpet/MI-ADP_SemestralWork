package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

/**
 * Interface for missile movement strategies.
 */
public interface IMissileMovingStrategy {

    void updatePosition(AbsMissile missile);

}