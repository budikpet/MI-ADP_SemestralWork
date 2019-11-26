package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Missile_A;
import cz.cvut.fit.miadp.mvcgame.strategy.missile.GravityMissileMoveStrategy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GravityMissileMoveStrategyTest {

    @Test
    public void nextPositionsTest() {
        GravityMissileMoveStrategy str = new GravityMissileMoveStrategy();
        Position pos = new Position(0, 0);
        Missile_A missile = new Missile_A(str, pos, 0, 0);
        
        // Prepare missile
        Missile_A missileSpy = spy(missile);
        when(missileSpy.getStartPos()).thenReturn(pos);
        when(missileSpy.getOffsetX()).thenReturn(0.0);
        when(missileSpy.getOffsetY()).thenReturn(0.0);
        when(missileSpy.getAge()).thenReturn(0l);
        when(missileSpy.getInitPower()).thenReturn(10.0);
        when(missileSpy.getInitAngle()).thenReturn(0.0);
        
        // Run tests for positions of the Gravity strategy
        str.updatePosition(missileSpy);
        Assert.assertEquals(pos.getY(), missileSpy.getY());
        Assert.assertEquals(pos.getX(), missileSpy.getX());

        when(missileSpy.getAge()).thenReturn(1000l);
        str.updatePosition(missileSpy);
        assertTrue("Y greater", missileSpy.getY() > pos.getY());
        assertTrue("X greater", missileSpy.getY() > pos.getY());
    }
    
}
