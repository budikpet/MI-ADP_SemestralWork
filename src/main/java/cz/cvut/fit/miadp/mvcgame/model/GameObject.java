package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class GameObject
{
    protected Position pos = new Position(0,0);

    public Position getPosition()
    {
        return new Position(this.pos);
    }

    public void move(int dx, int dy)
    {
        this.pos.move(dx,dy);
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

    public abstract void accept(IVisitor visitor);
}