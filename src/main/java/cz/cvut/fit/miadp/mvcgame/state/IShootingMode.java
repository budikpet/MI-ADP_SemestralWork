package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;

public interface IShootingMode
{
    void shoot(AbsCannon cannon);
    void toggle(AbsCannon cannon);
}