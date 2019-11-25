package cz.cvut.fit.miadp.mvcgame.state;

import java.util.Arrays;
import java.util.List;

/**
 * Contains names of all available ShootingModes and other useful functionalities.
 */
public enum ShootingModes {
    SINGLE_SHOOT, DOUBLE_SHOOT;

    private static List<ShootingModes> valuesList;

    static {
        valuesList = Arrays.asList(ShootingModes.class.getEnumConstants());
    }

    public ShootingModes toggle() {
        int newIndex = (valuesList.indexOf(this) + 1) % valuesList.size();
        return valuesList.get(newIndex);
    }

    public IShootingMode getMode() {
        switch(this) {
            case SINGLE_SHOOT:
                return SingleShootingMode.getInstance();
            case DOUBLE_SHOOT:
                return DoubleShootingMode.getInstance();
            default:
                return null;
        }
    }
}