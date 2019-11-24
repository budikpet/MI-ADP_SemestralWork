package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.command.AbsCommand;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

/**
 * Acts as an intermediary between actual GameModel and GameController. For
 * exaample could be used as a protection – different levels of access, which
 * the actual model does not have to know about
 */
public class GameModelProxy implements IGameModel {
    private IGameModel subject;

    public GameModelProxy(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    public void moveCannonUp() {
        this.subject.moveCannonUp();
    }

    @Override
    public void moveCannonDown() {
        this.subject.moveCannonDown();
    }

    @Override
    public void cannonShoot() {
        this.subject.cannonShoot();
    }

    @Override
    public void toggleShootingMode() {
        this.subject.toggleShootingMode();
    }

    @Override
    public void aimUp() {
        this.subject.aimUp();
    }

    @Override
    public void aimDown() {
        this.subject.aimDown();
    }

    @Override
    public void incPower() {
        this.subject.incPower();
    }

    @Override
    public void decPower() {
        this.subject.decPower();
    }

    @Override
    public void registerCommand(AbsCommand cmd) {
        this.subject.registerCommand(cmd);
    }

    @Override
    public Object createMemento() {
        return this.subject.createMemento();
    }

    @Override
    public void setMemento(Object memento) {
        this.subject.setMemento(memento);
    }

    @Override
    public void undoLastCmd() {
        this.subject.undoLastCmd();
    }

}