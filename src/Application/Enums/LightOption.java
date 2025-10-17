package Application.Enums;

public enum LightOption
{
    OPERATE(1),
    CHANGE_STATE(2),
    CHANGE_LIGHT(3),
    TURN_OFF(4),
    EXIT(5);

    private final int value;

    LightOption(int value) {
        this.value = value;
    }

    public static LightOption fromValue(int value) {
        for (LightOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
