package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Cannon_A;


@RunWith(MockitoJUnitRunner.class)
public class GameObjsFact_ATest {

    private GameObjsFac_A factory;
    
    @Before
    public void initFactory() {
        this.factory = new GameObjsFac_A();
    }
    
    @Test
    public void createMissileTest() {
        Position pos = new Position(100, 100);
        double angle = 100.0;
        double power = 100.0;
        
        // Prepare mock cannon
        Cannon_A cannon = mock(Cannon_A.class);
        when(cannon.getPosition()).thenReturn(pos);
        when(cannon.getAngle()).thenReturn(angle);
        when(cannon.getPower()).thenReturn(power);
        
        // Run missile creation test
        AbsMissile mis = this.factory.createMissile(cannon);
        Assert.assertEquals(angle, mis.getInitAngle(), 0.00001);
        Assert.assertEquals(power / 18.0, mis.getInitPower(), 0.00001);
        Assert.assertEquals(pos.getX(), mis.getX());
        Assert.assertEquals(pos.getY(), mis.getY());
    }

}
