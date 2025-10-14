package Decorators;

import Devices.Device;
import Enums.RemoteCommand;

public class RemoteAccessDecorator extends DeviceDecorator{

    public RemoteAccessDecorator(Device device)
    {
        super(device);
    }

    @Override
    public String operate() {
        return getDevice().operate() + " by Remote Control";
    }

    @Override
    public String turnOf() {
        return getDevice().turnOf() + " by Remote Control";
    }


    @Override
    public void remoteAccess(RemoteCommand remoteCommand) {
        System.out.println(
                switch (remoteCommand){
                    case OPERATE -> operate();
                    case TURNOFF -> turnOf();
                    default -> "Unknown Command";
                }
        );
    }
}
