package cz.cvut.fit.miadp.mvcgame.model;

/**
 * Adds a lifetime to a game object.
 */
public enum DirectionEnum {
    LEFT, RIGHT, UP, DOWN;

    public int getValue() {
        if(this == LEFT || this == UP) {
            return -1;
        } 
        
        return 1;
    }
}