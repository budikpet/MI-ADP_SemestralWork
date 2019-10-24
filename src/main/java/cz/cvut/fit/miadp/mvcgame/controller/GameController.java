package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;

public class GameController {

    private GameModel model;

    public GameController(GameModel model)
    {
        this.model = model;
    }

	public void handleKeyPress(String code) {

        switch(code){
            case "UP":
                this.model.moveLogoUp();
                break;
            case "DOWN":
                this.model.moveLogoDown();
                break;
            case "LEFT":
                this.model.moveLogoLeft();
                break;
            case "RIGHT":
                this.model.moveLogoRight();
                break;
            default: 
                //nothing
        }

	}

}
