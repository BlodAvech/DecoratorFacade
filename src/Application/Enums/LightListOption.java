package Application.Enums;

public enum LightListOption {
    ADD_NEW_LIGHT(1),
    REMOVE_LIGHT(2),
    GET_LIGHT_LIST(3),
    SELECT_LIGHT(4),
    OPERATE(5),
    TURN_OFF(6),
    EXIT(7);

    private final int value;

    LightListOption(int value) {
        this.value = value;
    }

    public static LightListOption fromValue(int value) {
        for (LightListOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
