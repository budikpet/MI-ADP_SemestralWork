package cz.cvut.fit.miadp.mvcgame.strategy.enemy;

import java.util.Random;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.DirectionEnum;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;

/**
 * Base missile movement strategy.
 */
public class SimpleEnemyMoveStrategy implements IEnemyMovingStrategy {
    private static SimpleEnemyMoveStrategy instance;

    static {
        instance = new SimpleEnemyMoveStrategy();
    }

    @Override
    public void updatePosition(AbsEnemy enemy) {
        // Random rand = new Random();
        // int newX = rand.nextInt(MvcGameConfig.MOVE_STEP);
        // int newY = rand.nextInt(MvcGameConfig.MOVE_STEP);
        // enemy.move(newX, newY);

        Position pos = enemy.getPosition();

        if(pos.getY() < 0) {
            enemy.setDirection(DirectionEnum.DOWN);
        } else if(pos.getY() > MvcGameConfig.MAX_Y) {
            enemy.setDirection(DirectionEnum.UP);
        }

        enemy.move(0, enemy.getDirection().getValue() * MvcGameConfig.MOVE_STEP);
    }

    public static SimpleEnemyMoveStrategy getInstance() {
        return instance;
    }
}