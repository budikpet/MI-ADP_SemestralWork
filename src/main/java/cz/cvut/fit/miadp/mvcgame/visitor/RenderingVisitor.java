package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;


public class RenderingVisitor implements IVisitor {


    private IGameGraphics gr;

    public RenderingVisitor(){
    }

    public void setGraphics(IGameGraphics gr)
    {
        this.gr = gr;
    }

    @Override
    public void visitCannon(AbsCannon go) {
        this.drawCannon(go);

    }

    private void drawCannon(AbsCannon go) {
        if(this.gr == null)  return;

        this.gr.drawImage("images/cannon.png", go.getPosition());
    }

    @Override
    public void visitEnemy(AbsEnemy go) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitGameInfo(AbsModelInfo go) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitMissile(AbsMissile go) {
        if(this.gr == null)  return;

        this.gr.drawImage("images/missile.png", go.getPosition());

    }

    @Override
    public void visitCollision(AbsCollision go) {
        // TODO Auto-generated method stub

    }


}