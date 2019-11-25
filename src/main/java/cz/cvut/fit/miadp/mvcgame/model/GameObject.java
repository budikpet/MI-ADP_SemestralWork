package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class GameObject {
    protected Position pos = new Position(0, 0);

    /**
     * Connect a provided IVisitor with this GameObject.
     * 
     * @param visitor is a concrete Visitor.
     */
    public abstract void accept(IVisitor visitor);

    public void move(int dx, int dy) {
        this.pos.move(dx, dy);
    }

    /**
     * Check collision of 2 GameObjects.
     * @param otherObject
     * @return True if GameObjects collide.
     */
    public boolean collidesWith(GameObject otherObject) {
        int aX = this.getX();
        int aY = this.getY();
        int bX = otherObject.getX();
        int bY = otherObject.getY();

        // PIXELS_NEEDED_TO_COLLIDE - wouldn't be necessary if sizes of both GameObjects were known
        boolean xMayCollide = Math.abs(aX - bX) < MvcGameConfig.PIXELS_NEEDED_TO_COLLIDE;
        boolean yMayCollide = Math.abs(aY - bY) < MvcGameConfig.PIXELS_NEEDED_TO_COLLIDE;

        return xMayCollide && yMayCollide;
    }

    // ================================================================================
    // Getters/Setters
    // ================================================================================

    public Position getPosition() {
        return new Position(this.pos);
    }

    public int getX() {
        return this.pos.getX();
    }

    public int getY() {
        return this.pos.getY();
    }

    public void setX(int x) {
        this.pos.setX(x);
    }

    public void setY(int y) {
        this.pos.setY(y);
    }
}