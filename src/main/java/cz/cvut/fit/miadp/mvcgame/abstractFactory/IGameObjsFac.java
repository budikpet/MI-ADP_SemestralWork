package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

/**
 * Interface for creation of all game objects.
 */
public interface IGameObjsFac {
    AbsCannon createCannon();

    AbsCollision createCollision();

    AbsEnemy createEnemy();

    AbsMissile createMissile(AbsCannon cannon);

    AbsGameInfo createGameInfo(IGameModel model);
}