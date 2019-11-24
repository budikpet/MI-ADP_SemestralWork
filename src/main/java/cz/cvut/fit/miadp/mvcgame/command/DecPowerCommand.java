package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class DecPowerCommand extends AbsCommand {
    public DecPowerCommand(IGameModel receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.receiver.decPower();
    }

}
