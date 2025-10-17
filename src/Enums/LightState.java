    package Enums;

    public enum LightState {
        BRIGHT(1),
        NORMAL(2),
        DIM(3),
        OFF(4);

        private final int value;

        LightState(int value) {
            this.value = value;
        }

        public static LightState fromValue(int value) {
            for (LightState option : values()) {
                if (option.value == value) {
                    return option;
                }
            }
            throw new IllegalArgumentException("Invalid menu option: " + value);
        }
    }
