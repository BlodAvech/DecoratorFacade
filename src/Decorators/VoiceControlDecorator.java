package Decorators;

import Devices.Device;

public class VoiceControlDecorator extends DeviceDecorator {

    private String voiceCommand = "Turn On";

    public VoiceControlDecorator(Device device) {
        super(device);
    }

    @Override
    public String operate() {
        return getDevice().operate() + " by Voice Control";
    }

}
