package Application.Enums;

import Enums.MusicVolume;

public enum ThermostatOption {
    OPERATE(1),
    CHANGE_STATE(2),
    SET_TEMPERATURE(3),
    GET_TEMPERATURE(4),
    TURN_OFF(5),
    EXIT(6);

    private final int value;

    ThermostatOption(int value) {
        this.value = value;
    }

    public static ThermostatOption fromValue(int value) {
        for (ThermostatOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
