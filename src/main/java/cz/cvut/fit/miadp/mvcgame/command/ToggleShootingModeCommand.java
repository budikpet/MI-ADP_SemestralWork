package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class ToggleShootingModeCommand extends AbsCommand {
    public ToggleShootingModeCommand(IGameModel receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.receiver.toggleShootingMode();
    }

}
