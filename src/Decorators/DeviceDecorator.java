package Decorators;

import Devices.Device;

public abstract class DeviceDecorator implements Device {
    private final Device device;

    public DeviceDecorator(Device device)
    {
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }
}
