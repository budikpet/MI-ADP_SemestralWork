package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class IncPowerCommand extends AbsCommand {
    public IncPowerCommand(IGameModel receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.receiver.incPower();
    }

}
