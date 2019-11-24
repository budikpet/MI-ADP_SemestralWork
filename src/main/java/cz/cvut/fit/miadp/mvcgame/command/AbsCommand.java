package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

/**
 * Abstract class for Commands. Game logic is executed through commands.
 */
public abstract class AbsCommand {
    private Object memento;
    protected IGameModel receiver;

    public AbsCommand(IGameModel rec) {
        this.receiver = rec;
    }

    public void doExecute() {
        this.memento = this.receiver.createMemento();

        this.execute();
    }

    protected abstract void execute();

    public void unexecute() {
        this.receiver.setMemento(this.memento);
    }
}