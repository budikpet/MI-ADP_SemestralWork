package cz.cvut.fit.miadp.mvcgame.config;

/**
 * Important game-wide constants.
 */
public class MvcGameConfig {
    public static final int MAX_X = 1280;
    public static final int MAX_Y = 720;
    public static final int REMOVAL_PADDING = 100;
    public static final int INFO_X = 10;
    public static final int INFO_Y = 20;
    public static final int CANNON_INIT_X = 10;
    public static final long RELOAD_MS = 500;
    public static final int NUM_OF_ENEMIES = 20;
    public static final long DEBOUNCE_MIN_INTERVAL_MS = 250;

    public static final double INIT_POWER = 10;
    public static final double INIT_ANGLE = 0.0;
    public static final double INIT_GRAVITY = 0.0001;

    public static final int MOVE_STEP = 10;
    public static final double POWER_STEP = 1.0;
    public static final double ANGLE_STEP = 0.1;

    public static final int PIXELS_NEEDED_TO_COLLIDE = 20;
    public static final long MAX_COLLISION_TIME_MS = 1000;
}