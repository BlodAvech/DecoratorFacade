package Devices;

import Enums.RemoteCommand;
import Enums.VoiceCommand;

public interface  Device {

    public abstract String operate();
    public abstract String turnOf();

    default void voiceCommand(VoiceCommand command) {}
    default void saveEnergy() {}
    default void remoteAccess(RemoteCommand command) {}
}