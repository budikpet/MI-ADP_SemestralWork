package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;

/**
 * Interface for creation of all game objects.
 */
public interface IGameObjsFac {
    AbsCannon createCannon();

    AbsCollision createCollision();

    AbsEnemy createEnemy();

    AbsMissile createMissile();

    AbsModelInfo createModelInfo();
}