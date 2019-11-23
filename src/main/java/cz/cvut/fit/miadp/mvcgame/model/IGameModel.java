package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.command.AbsCommand;

public interface IGameModel {

    void moveCannonUp();
    void moveCannonDown();
    void cannonShoot();
    void toggleShootingMode();


    void registerCommand(AbsCommand cmd);
    
    Object createMemento();
    void setMemento(Object memento);

    void undoLastCmd();

}
