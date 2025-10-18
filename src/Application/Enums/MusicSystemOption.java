package Application.Enums;

public enum MusicSystemOption {
    OPERATE(1),
    SET_VOLUME(2),
    SET_MUSIC(3),
    RESET_MUSIC(4),
    STOP_PLAYING(5),
    GET_CURRENT_MUSIC(6),
    TURN_OFF(7),
    DECORATORS(8),
    EXIT(9);

    private final int value;

    MusicSystemOption(int value) {
        this.value = value;
    }

    public static MusicSystemOption fromValue(int value) {
        for (MusicSystemOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
