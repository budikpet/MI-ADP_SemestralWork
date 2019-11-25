package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

/**
 * Gravity missile movement strategy.
 */
public class GravityMoveStrategy implements IMovingStrategy {

    @Override
    public void updatePosition(AbsMissile mis) {
        double newX = mis.getStartPos().getX() + ( mis.getAge() * (mis.getInitPower() - mis.getAge() * 0.00007f) * Math.cos(mis.getInitAngle()));
        double newY = mis.getStartPos().getY() + ( mis.getAge() * mis.getInitPower() * Math.sin(mis.getInitAngle())) + Math.pow(mis.getAge(), 2) * MvcGameConfig.INIT_GRAVITY;
        
        mis.setX((int)(newX));
        mis.setY((int)(newY));
    }
}