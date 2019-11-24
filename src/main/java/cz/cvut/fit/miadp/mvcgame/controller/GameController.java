package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.command.CannonShootCommand;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonDownCommand;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonUpCommand;
import cz.cvut.fit.miadp.mvcgame.command.ToggleShootingModeCommand;
import cz.cvut.fit.miadp.mvcgame.command.UndoLastCommand;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

/**
 * MVC controller.
 * 
 * Handles pressed keys and runs appropriate GameModel logic.
 */
public class GameController {
    private IGameModel model;

    public GameController(IGameModel model) {
        this.model = model;
    }

    public void handleKeyCode(String keyCode) {
        switch (keyCode) {
        case "UP":
            this.model.registerCommand(new MoveCannonUpCommand(this.model));
            break;
        case "DOWN":
            this.model.registerCommand(new MoveCannonDownCommand(this.model));
            break;
        case "SPACE":
            this.model.registerCommand(new CannonShootCommand(this.model));
            break;
        case "M":
            this.model.registerCommand(new ToggleShootingModeCommand(this.model));
            break;
        case "Z":
            this.model.registerCommand(new UndoLastCommand(this.model));
            break;
        default:
            // nothing
        }
    }

}
