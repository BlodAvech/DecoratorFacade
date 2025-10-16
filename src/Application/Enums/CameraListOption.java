package Application.Enums;

public enum CameraListOption
{
    ADD_NEW_CAMERA(1),
    DELETE_CAMERA(2),
    GET_CAMERA_LIST(3),
    OPERATE(4),
    TURN_OFF(5),
    EXIT(6);

    private final int value;

    CameraListOption(int value) {
        this.value = value;
    }

    public static CameraListOption fromValue(int value) {
        for (CameraListOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}
