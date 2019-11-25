package cz.cvut.fit.miadp.mvcgame.model;

/**
 * Adds a lifetime to a game object.
 */
public abstract class TimelifeAwareGameObject extends GameObject {
    private long created = System.currentTimeMillis();

    public long getAge() {
        return System.currentTimeMillis() - this.created;
    }

}