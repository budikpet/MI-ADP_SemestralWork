package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class AimDownCommand extends AbsCommand {
    public AimDownCommand(IGameModel receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.receiver.aimDown();
    }

}
