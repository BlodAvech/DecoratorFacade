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
        Device musicSystemDecorator = new EnergySavingDecorator(new VoiceControlDecorator(new MusicSystem()));
        Device lightDecorator = new EnergySavingDecorator(new RemoteAccessDecorator(new Light(new HalogenLamp())));

        Light light = new Light(new IncandescentLamp());
        MusicSystem musicSystem = new MusicSystem();
        SecurityCamera securityCamera = new SecurityCamera();
        TemperatureAndHumiditySensor temperatureAndHumiditySensor = new TemperatureAndHumiditySensor();

        IoTFacade facade = new IoTFacade(light , musicSystem , securityCamera , temperatureAndHumiditySensor);

        System.out.println(musicSystemDecorator.operate());
        System.out.println("\n");
        System.out.println(lightDecorator.operate());
        System.out.println("\n");

        facade.OnCameHome();
        System.out.println("\n");
        facade.OnLeftHome();
    }
}
