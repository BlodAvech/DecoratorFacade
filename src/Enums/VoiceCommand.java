package Enums;

import Application.Enums.DecoratorsOption;

import java.util.Objects;

public enum VoiceCommand {
    OPERATE("operate"),
    TURNOFF("turnoff"),
    UNKNOWN("");


    private final String value;

    VoiceCommand(String value) {
        this.value = value;
    }

    public static VoiceCommand fromValue(String value) {
        for (VoiceCommand option : values()) {
            if (Objects.equals(option.value, value)) {
                return option;
            }
        }
        return VoiceCommand.UNKNOWN;
    }
}
