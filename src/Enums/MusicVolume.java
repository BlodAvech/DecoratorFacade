package Enums;

import Application.Enums.MenuOption;

public enum MusicVolume {
    HIGH(1),
    MEDIUM(2),
    LOW(3),
    MUTE(4);

    private final int value;

    MusicVolume(int value) {
        this.value = value;
    }

    public static MusicVolume fromValue(int value) {
        for (MusicVolume option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
