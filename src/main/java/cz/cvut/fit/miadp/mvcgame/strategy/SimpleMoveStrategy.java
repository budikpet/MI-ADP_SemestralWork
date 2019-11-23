package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public class SimpleMoveStrategy implements IMovingStrategy {

    @Override
    public void updatePosition(AbsMissile mis) {
        
        mis.move(MvcGameConfig.MOVE_STEP/2, 0);

    }


}