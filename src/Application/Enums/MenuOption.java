package Application.Enums;

public enum MenuOption {
    LIGHTS_LIST(1),
    MUSIC_SYSTEM(2),
    THERMOSTAT(3),
    SECURITY_CAMERAS(4),
    FACADE(5),
    EXIT(6);

    private final int value;

    MenuOption(int value) {
        this.value = value;
    }

    public static MenuOption fromValue(int value) {
        for (MenuOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}