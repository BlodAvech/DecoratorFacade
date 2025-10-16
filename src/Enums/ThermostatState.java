package Enums;

public enum ThermostatState {
    PRODUCTIVE(1),
    GENERAL(2),
    ECO(3),
    OFF(4);

    private final int value;

    ThermostatState(int value) {
        this.value = value;
    }

    public static ThermostatState fromValue(int value) {
        for (ThermostatState option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
