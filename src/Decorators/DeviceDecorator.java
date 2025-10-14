package Decorators;

import Devices.Device;
import Enums.RemoteCommand;
import Enums.VoiceCommand;

public abstract class DeviceDecorator implements Device {
    private final Device device;

    public DeviceDecorator(Device device)
    {
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }

    @Override
    public void voiceCommand(VoiceCommand command) {
        device.voiceCommand(command);
    }

    @Override
    public void saveEnergy() {
        device.saveEnergy();
    }

    @Override
    public void remoteAccess(RemoteCommand command) {
        device.remoteAccess(command);
    }
}
