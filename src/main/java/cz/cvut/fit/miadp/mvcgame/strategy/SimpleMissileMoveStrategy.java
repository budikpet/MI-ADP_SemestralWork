package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

/**
 * Base missile movement strategy.
 */
public class SimpleMissileMoveStrategy implements IMissileMovingStrategy {

    @Override
    public void updatePosition(AbsMissile mis) {
        mis.move(MvcGameConfig.MOVE_STEP / 2, 0);
    }
}