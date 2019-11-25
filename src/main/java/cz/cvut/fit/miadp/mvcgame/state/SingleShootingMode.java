package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;

public class SingleShootingMode implements IShootingMode {
    private static SingleShootingMode instance;

    private SingleShootingMode() {}

    static {
        instance = new SingleShootingMode();
    }

    @Override
    public void shoot(AbsCannon cannon) {
        cannon.primitiveShoot();
    }

    public static IShootingMode getInstance() {
        return instance;
    }

}