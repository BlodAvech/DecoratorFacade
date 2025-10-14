package Decorators;

import Devices.Device;
import Enums.VoiceCommand;

public class VoiceControlDecorator extends DeviceDecorator {


    public VoiceControlDecorator(Device device) {
        super(device);
    }

    @Override
    public String operate() {
        return getDevice().operate() + " by Voice Control";
    }

    @Override
    public String turnOf() {
        return getDevice().turnOf() + " by Voice Control";
    }

    @Override
    public void voiceCommand(VoiceCommand voiceCommand)
    {
        System.out.println(
                switch (voiceCommand){
                    case OPERATE -> operate();
                    case TURNOFF -> turnOf();
                    default -> "Unknown Command";
                }
        );
    }
}
