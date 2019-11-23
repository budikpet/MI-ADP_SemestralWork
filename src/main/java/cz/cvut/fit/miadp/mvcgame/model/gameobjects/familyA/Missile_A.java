package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class Missile_A extends AbsMissile
{
    
    private IMovingStrategy moveStrat;

    public Missile_A(IMovingStrategy myMoveStrat)
    {
        this.moveStrat = myMoveStrat;
    }

    @Override
    public void move()
    {
        this.moveStrat.updatePosition(this);
    }

}
