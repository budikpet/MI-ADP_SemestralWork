package cz.cvut.fit.miadp.mvcgame.model;

import junit.framework.Assert;
import org.junit.Test;


public class DoubleShootModeTest {

    @Test
    public void doubleShootModeTest() {
        GameModel model = new GameModel();
        model.cannonShoot();
        
        // Check that correct number of missiles exist
        Assert.assertEquals(2, model.getMissilesCount());
    }
}
