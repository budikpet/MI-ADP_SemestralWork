package cz.cvut.fit.miadp.mvcgame.strategy.enemy;

import java.util.Arrays;
import java.util.List;

/**
 * Contains names of all available EnemyMovementStrategies and other useful functionalities.
 */
public enum EnemyMovementStrategies {
    SIMPLE;

    private static List<EnemyMovementStrategies> valuesList;

    static {
        valuesList = Arrays.asList(EnemyMovementStrategies.class.getEnumConstants());
    }

    public static List<EnemyMovementStrategies> getValues() {
        return valuesList;
    }

    public IEnemyMovingStrategy getStrategy() {
        switch(this) {
            case SIMPLE:
                return SimpleEnemyMoveStrategy.getInstance();
            default:
                return null;
        }
    }
}