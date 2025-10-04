import Devices.Light;
import Devices.MusicSystem;
import Devices.SecurityCamera;
import Devices.TemperatureAndHumiditySensor;

public class IoTFacade
{
    private Light light;
    private MusicSystem musicSystem;
    private SecurityCamera securityCamera;
    private TemperatureAndHumiditySensor temperatureAndHumiditySensor;

    public IoTFacade(Light light , MusicSystem musicSystem , SecurityCamera securityCamera , TemperatureAndHumiditySensor temperatureAndHumiditySensor)
    {
        this.light = light;
        this.musicSystem = musicSystem;
        this.securityCamera = securityCamera;
        this.temperatureAndHumiditySensor = temperatureAndHumiditySensor;
    }

    public void OnCameHome()
    {
        System.out.println(light.operate());
        System.out.println(musicSystem.operate());
        securityCamera.stopRecording();
        System.out.println(temperatureAndHumiditySensor.operate());
    }

    public void OnLeftHome()
    {
        light.turnOff();
        musicSystem.stopPlaying();
        System.out.println(securityCamera.operate());
    }
}
