package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;
import cz.cvut.fit.miadp.mvcgame.visitor.RenderingVisitor;

/**
 * MVC view. Has game objects rendered. Acts as an observer.
 */
public class GameView implements IObserver {
    private GameModel model;
    private IVisitor renderingVisitor;
    private int updateCnt = 1;
    private IGameGraphics gr;

    public GameView(GameModel model) {
        this.model = model;

        this.model.registerObserver(this);

        this.renderingVisitor = RenderingVisitor.getInstance();
    }

    public void setGraphics(IGameGraphics gr) {
        this.gr = gr;
        this.renderingVisitor.setGraphics(gr);
    }

    public GameController makeController() {
        return new GameController(new GameModelProxy(model));
    }

    public void update() {
        this.updateCnt++;
    }

    /**
     * Renderes game objects by passing the RenderingVisitor instance to all active
     * game objects.
     */
    public void render() {
        if (this.updateCnt > 0) {

            // Clear the canvas
            this.gr.clear();

            for (GameObject go : this.model.getGameObjects()) {
                go.accept(this.renderingVisitor);
            }

            this.updateCnt = 0;
        }
    }

}
