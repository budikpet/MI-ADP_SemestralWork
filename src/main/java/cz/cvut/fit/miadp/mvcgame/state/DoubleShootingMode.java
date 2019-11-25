package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public class DoubleShootingMode implements IShootingMode {

    @Override
    public void shoot(AbsCannon cannon) {
        for(int i = 0; i < 2; i++) {
            AbsMissile missile = cannon.primitiveShoot();
            missile.setOffsetY(-3 * i * MvcGameConfig.MOVE_STEP);
        }

        
        // missile.move(0, MvcGameConfig.MOVE_STEP);

        // missile.move(0, -1 * MvcGameConfig.MOVE_STEP);
    }

    @Override
    public void toggle(AbsCannon cannon) {
        cannon.setSingleShootingMode();
    }

}