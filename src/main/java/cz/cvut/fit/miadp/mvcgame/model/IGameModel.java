package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.command.AbsCommand;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;

public interface IGameModel {

    void moveCannonUp();

    void moveCannonDown();

    void cannonShoot();

    void toggleShootingMode();

    void aimUp();

    void aimDown();

    void incPower();

    void decPower();

    void registerCommand(AbsCommand cmd);

    Object createMemento();

    void setMemento(Object memento);

    void undoLastCmd();

    AbsCannon getCannon();
    int getScore();
    int getMissilesCount();
    int getEnemiesCount();

}
