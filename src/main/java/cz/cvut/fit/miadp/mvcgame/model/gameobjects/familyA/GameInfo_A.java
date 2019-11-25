package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;

public class GameInfo_A extends AbsGameInfo {

    public GameInfo_A(IGameModel model) {
        super(model);
    }

    public String getText() {
        AbsCannon cannon = model.getCannon();
        
        return String.format("Score: %d; Cannon position: [%d, %d], angle: %f, power: %f; Missiles count: %d; Enemies count: %d",
            model.getScore(), 
            cannon.getX(), cannon.getY(), cannon.getAngle(), cannon.getPower(), 
            model.getMissilesCount(), model.getEnemiesCount()
        );
    }
}
