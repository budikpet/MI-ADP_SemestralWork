package cz.cvut.fit.miadp.mvcgame.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import cz.cvut.fit.miadp.mvcgame.command.AimDownCommand;
import cz.cvut.fit.miadp.mvcgame.command.AimUpCommand;
import cz.cvut.fit.miadp.mvcgame.command.CannonShootCommand;
import cz.cvut.fit.miadp.mvcgame.command.DecPowerCommand;
import cz.cvut.fit.miadp.mvcgame.command.IncPowerCommand;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonDownCommand;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonUpCommand;
import cz.cvut.fit.miadp.mvcgame.command.ToggleShootingModeCommand;
import cz.cvut.fit.miadp.mvcgame.command.UndoLastCommand;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

/**
 * MVC controller.
 * 
 * Handles pressed keys and runs appropriate GameModel logic.
 */
public class GameController {
    private IGameModel model;
    private HashMap<String, Long> calledKeyTimes;
    private HashSet<String> debouncedKeys;

    public GameController(IGameModel model) {
        this.model = model;
        this.calledKeyTimes = new HashMap<>();
        this.debouncedKeys = new HashSet<>(Arrays.asList("M", "LEFT", "RIGHT", "UP", "DOWN"));
    }

    protected void handleKeyCode(String keyCode) {
        switch (keyCode) {
        case "W":
            this.model.registerCommand(new MoveCannonUpCommand(this.model));
            break;
        case "S":
            this.model.registerCommand(new MoveCannonDownCommand(this.model));
            break;
        case "SPACE":
            this.model.registerCommand(new CannonShootCommand(this.model));
            break;
        case "M":
            this.model.registerCommand(new ToggleShootingModeCommand(this.model));
            break;
        case "UP":
            this.model.registerCommand(new AimUpCommand(this.model));
            break;
        case "DOWN":
            this.model.registerCommand(new AimDownCommand(this.model));
            break;
        case "LEFT":
            this.model.registerCommand(new DecPowerCommand(this.model));
            break;
        case "RIGHT":
            this.model.registerCommand(new IncPowerCommand(this.model));
            break;
        case "U":
            this.model.registerCommand(new UndoLastCommand(this.model));
            break;
        default:
            // nothing
        }
    }

    public void handleKeyCodeWithDebounce(String keyCode) {
        if (debouncedKeys.contains(keyCode)) {
            long currTime = System.currentTimeMillis();

            if (!calledKeyTimes.containsKey(keyCode) || currTime - calledKeyTimes.get(keyCode) > MvcGameConfig.DEBOUNCE_MIN_INTERVAL_MS) {
                calledKeyTimes.put(keyCode, currTime);
                this.handleKeyCode(keyCode);
            }
        } else {
            this.handleKeyCode(keyCode);
        }
    }
}
