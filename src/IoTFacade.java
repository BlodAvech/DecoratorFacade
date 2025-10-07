import Devices.Light;
import Devices.MusicSystem;
import Devices.SecurityCamera;
import Devices.Thermostat;
import Enums.LightState;
import Enums.MusicVolume;
import Enums.ThermostatState;

public class IoTFacade
{
    private Light light;
    private MusicSystem musicSystem;
    private SecurityCamera securityCamera;
    private Thermostat thermostat;

    public IoTFacade(Light light , MusicSystem musicSystem , SecurityCamera securityCamera , Thermostat thermostat)
    {
        this.light = light;
        this.musicSystem = musicSystem;
        this.securityCamera = securityCamera;
        this.thermostat = thermostat;
    }

    public void cameHome()
    {
        System.out.println("Common Mode \n");
        System.out.println(light.operate());

        System.out.println(musicSystem.operate());
        musicSystem.setVolume(MusicVolume.LOW);

        System.out.println(thermostat.operate());

        securityCamera.stopRecording();

    }

    public void partyMode()
    {
        System.out.println("Party Mode \n");

        light.changeState(LightState.DIM);

        System.out.println(musicSystem.operate());
        musicSystem.setVolume(MusicVolume.HIGH);

        thermostat.changeState(ThermostatState.PRODUCTIVE);

        securityCamera.stopRecording();
    }

    public void nightMode()
    {
        System.out.println("Night Mode \n");

        light.changeState(LightState.OFF);

        musicSystem.stopPlaying();

        thermostat.changeState(ThermostatState.ECO);

        System.out.println(securityCamera.operate());

    }

    public void leaveHome()
    {
        System.out.println("Off Mode \n");

        light.changeState(LightState.OFF);

        musicSystem.stopPlaying();

        thermostat.changeState(ThermostatState.OFF);

        System.out.println(securityCamera.operate());

    }
}
