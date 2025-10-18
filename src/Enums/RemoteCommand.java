package Enums;

import java.util.Objects;

public enum RemoteCommand
{
    OPERATE(1),
    TURNOFF(2);

    private final int value;

    RemoteCommand(int value) {
        this.value = value;
    }

    public static RemoteCommand fromValue(int value) {
        for (RemoteCommand option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
