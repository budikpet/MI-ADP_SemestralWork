package cz.cvut.fit.miadp.mvcgame.model;

import java.util.Date;

public abstract class LifetimeLimitedGameObject extends GameObject
{
    protected Date bornAt;

    public int getAge() {
        return 0; //((new Date())-this.bornAt);
    }


}