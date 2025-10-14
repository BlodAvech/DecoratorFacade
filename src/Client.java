import Decorators.DeviceDecorator;
import Decorators.EnergySavingDecorator;
import Decorators.RemoteAccessDecorator;
import Decorators.VoiceControlDecorator;
import Devices.*;
import LightTypes.*;

public class Client
{
    public void Execute()
    {
        Light light = new Light(new IncandescentLamp() , 200f);
        MusicSystem musicSystem = new MusicSystem(150f);
        SecurityCamera securityCamera = new SecurityCamera(100f);
        Thermostat thermostat = new Thermostat(50f);

        EnergySavingDecorator musicSystemDecorator = new EnergySavingDecorator(new VoiceControlDecorator(musicSystem) , musicSystem);
        EnergySavingDecorator lightDecorator = new EnergySavingDecorator(new RemoteAccessDecorator(light) , light);

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

        light.getInfo();
        lightDecorator.saveEnergy();
        musicSystemDecorator.saveEnergy();
    }
}
