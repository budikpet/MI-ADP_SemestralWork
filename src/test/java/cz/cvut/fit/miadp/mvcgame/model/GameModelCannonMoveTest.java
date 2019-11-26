package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GameModelCannonMoveTest {


    @Test
    public void testCannonMovement() throws InterruptedException {
        GameModel model = new GameModel();
        int initY = (int) (MvcGameConfig.MAX_Y / 2);
        
        // Check if cannon moves properly
        model.moveCannonDown();
        Assert.assertEquals(initY + MvcGameConfig.MOVE_STEP, model.getCannon().getY());
        Assert.assertEquals(MvcGameConfig.CANNON_INIT_X, model.getCannon().getX());

        model.moveCannonDown();
        Assert.assertEquals(initY + 2*MvcGameConfig.MOVE_STEP, model.getCannon().getY());
        Assert.assertEquals(MvcGameConfig.CANNON_INIT_X, model.getCannon().getX());

        model.moveCannonUp();
        model.moveCannonUp();
        Assert.assertEquals(initY, model.getCannon().getY());
        Assert.assertEquals(MvcGameConfig.CANNON_INIT_X, model.getCannon().getX());
    }
    
}
