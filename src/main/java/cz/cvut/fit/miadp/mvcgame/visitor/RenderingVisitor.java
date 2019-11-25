package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;

/**
 * Visitor which renderes game objects on the screen.
 */
public class RenderingVisitor implements IVisitor {
    private IGameGraphics gr;

    private RenderingVisitor() {}

    public void setGraphics(IGameGraphics gr) {
        this.gr = gr;
    }

    @Override
    public void visitCannon(AbsCannon go) {
        this.drawCannon(go);
    }

    private void drawCannon(AbsCannon go) {
        if (this.gr == null)
            return;

        this.gr.drawImage("images/cannon.png", go.getPosition());
    }

    @Override
    public void visitEnemy(AbsEnemy go) {
        if (this.gr == null)
            return;

        this.gr.drawImage("images/enemy1.png", go.getPosition());
    }

    @Override
    public void visitGameInfo(AbsGameInfo go) {
        if (this.gr == null) {
            return;
        }
        
        this.gr.drawText(go.getText(), new Position(MvcGameConfig.INFO_X, MvcGameConfig.INFO_Y));
    }

    @Override
    public void visitMissile(AbsMissile go) {
        if (this.gr == null)
            return;

        this.gr.drawImage("images/missile.png", go.getPosition());
    }

    @Override
    public void visitCollision(AbsCollision go) {
        this.gr.drawImage("images/collision.png", go.getPosition());
    }

    public static RenderingVisitor getInstance() {
        return new RenderingVisitor();
    }

}