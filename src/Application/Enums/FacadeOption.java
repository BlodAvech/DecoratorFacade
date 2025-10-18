package Application.Enums;

public enum FacadeOption
{
    ON_MODE(1),
    PARTY_MODE(2),
    NIGHT_MODE(3),
    OFF_MODE(4),
    EXIT(5);

    private final int value;

    FacadeOption(int value) {
        this.value = value;
    }

    public static FacadeOption fromValue(int value) {
        for (FacadeOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
