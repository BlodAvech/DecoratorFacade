package Application.Enums;

public enum DecoratorsOption
{
    ENERGY_SAVE(1),
    REMOTE_ACCESS(2),
    VOICE_CONTROL(3),
    EXIT(4);

    private final int value;

    DecoratorsOption(int value) {
        this.value = value;
    }

    public static DecoratorsOption fromValue(int value) {
        for (DecoratorsOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
