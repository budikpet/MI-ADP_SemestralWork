package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class CannonShootCommand extends AbsCommand {
    public CannonShootCommand(IGameModel receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.receiver.cannonShoot();
    }

}
