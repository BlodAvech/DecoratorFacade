package Decorators;

import Devices.Device;

public class RemoteAccessDecorator extends DeviceDecorator{

    public RemoteAccessDecorator(Device device)
    {
        super(device);
    }

    @Override
    public String operate() {
        return getDevice().operate() + " by Remote Control";
    }

}
