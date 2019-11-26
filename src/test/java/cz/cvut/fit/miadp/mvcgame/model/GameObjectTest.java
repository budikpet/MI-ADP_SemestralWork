package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Enemy_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Missile_A;
import cz.cvut.fit.miadp.mvcgame.strategy.enemy.EnemyMovementStrategies;
import cz.cvut.fit.miadp.mvcgame.strategy.missile.SimpleMissileMoveStrategy;
import org.junit.Assert;
import org.junit.Test;

public class GameObjectTest {

    @Test
    public void collisionTest() {
        Position pos = new Position(100, 100);
        Missile_A m = new Missile_A(new SimpleMissileMoveStrategy(), pos, 0, 0);
        Enemy_A e = new Enemy_A(EnemyMovementStrategies.SIMPLE.getStrategy());
        
        // Check if collision works properly
        e.setPosition(pos);
        Assert.assertTrue(m.collidesWith(e));
        
        e.setX(0);
        e.setY(0);
        Assert.assertFalse(m.collidesWith(e));
    }
    
}
