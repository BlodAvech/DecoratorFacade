import Decorators.DeviceDecorator;
import Decorators.EnergySavingDecorator;
import Decorators.RemoteAccessDecorator;
import Decorators.VoiceControlDecorator;
import Devices.*;
import Enums.RemoteCommand;
import Enums.VoiceCommand;
import LightTypes.*;

public class Client
{
    public void Execute()
    {
        Light light = new Light(new IncandescentLamp() , 200f);
        MusicSystem musicSystem = new MusicSystem(150f);
        SecurityCamera securityCamera = new SecurityCamera(100f);
        Thermostat thermostat = new Thermostat(50f);

        Device musicSystemDecorator = new EnergySavingDecorator(new VoiceControlDecorator(musicSystem) , musicSystem);
        Device lightDecorator = new EnergySavingDecorator(new RemoteAccessDecorator(light) , light);

        IoTFacade facade = new IoTFacade(light , musicSystem , securityCamera , thermostat);

        System.out.println(musicSystemDecorator.operate());
        System.out.println("\n");
        System.out.println(lightDecorator.operate());
        System.out.println("\n");

        facade.cameHome();
        System.out.println("\n");
        facade.partyMode();
        System.out.println("\n");
        facade.nightMode();
        System.out.println("\n");
        facade.leaveHome();

        musicSystemDecorator.saveEnergy();
        musicSystemDecorator.voiceCommand(VoiceCommand.OPERATE);
        musicSystemDecorator.voiceCommand(VoiceCommand.TURNOFF);

        lightDecorator.saveEnergy();
        lightDecorator.remoteAccess(RemoteCommand.OPERATE);
        lightDecorator.remoteAccess(RemoteCommand.TURNOFF);

    }
}
