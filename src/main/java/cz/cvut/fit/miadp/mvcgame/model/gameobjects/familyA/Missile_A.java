package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMissileMovingStrategy;

public class Missile_A extends AbsMissile {

    private IMissileMovingStrategy moveStrat;

    public Missile_A(IMissileMovingStrategy myMoveStrat, Position pos, double initPower, double initAngle) {
        super(pos, initPower/ 18.0, initAngle);
        this.moveStrat = myMoveStrat;
    }

    @Override
    public void move() {
        this.moveStrat.updatePosition(this);
    }

}
