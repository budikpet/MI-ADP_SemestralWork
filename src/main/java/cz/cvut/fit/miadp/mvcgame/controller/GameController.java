package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.command.MoveCannonUpCommand;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class GameController {
    private IGameModel model;

	public GameController(IGameModel model) {
        this.model = model;
    }
    
    public void handleKeyCode(String keyCode)
    {
        switch(keyCode){
            case "UP":
                // this.model.moveCannonUp();
                this.model.registerCommand(new MoveCannonUpCommand(this.model));
                break;
            case "DOWN":
                this.model.moveCannonDown();
                break;
            case "SPACE":
                this.model.cannonShoot();
                break;
            case "M":
                this.model.toggleShootingMode();
                break;
            case "Z":
                this.model.undoLastCmd();
                break;
            default: 
                //nothing
        }
    }

}
