package Decorators;

import Devices.Device;

public class EnergySavingDecorator extends DeviceDecorator{

    public EnergySavingDecorator(Device device) {
        super(device);
    }

    @Override
    public String operate() {
        return getDevice().operate() + " with Energy Saving";
    }
}
