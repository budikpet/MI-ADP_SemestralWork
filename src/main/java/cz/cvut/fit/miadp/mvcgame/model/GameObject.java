package cz.cvut.fit.miadp.mvcgame.model;

public abstract class GameObject {

    protected Position pos;

    public void move(int dx, int dy)
    {
        this.pos.setX(this.pos.getX()+dx);
        this.pos.setY(this.pos.getY()+dy);
    }

}