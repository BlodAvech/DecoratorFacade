package Devices;

import Enums.RemoteCommand;
import Enums.VoiceCommand;

public interface  Device {

    public abstract String operate();
    public abstract String turnOf();

    default void voiceCommand(VoiceCommand command) {}
    default float getEnergyUse() {return 0;}
    default void remoteAccess(RemoteCommand command) {}
}