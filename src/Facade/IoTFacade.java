package Facade;

import Devices.Light;
import Devices.MusicSystem;
import Devices.SecurityCamera;
import Devices.Thermostat;
import Enums.LightState;
import Enums.MusicVolume;
import Enums.ThermostatState;

import java.util.List;

public class IoTFacade
{
    private List<Light> lights;
    private MusicSystem musicSystem;
    private Thermostat thermostat;
    private List<SecurityCamera> securityCameras;


    public IoTFacade(List<Light> lights , MusicSystem musicSystem , Thermostat thermostat , List<SecurityCamera> securityCameras)
    {
        this.lights = lights;
        this.musicSystem = musicSystem;
        this.securityCameras = securityCameras;
        this.thermostat = thermostat;
    }

    public void cameHome()
    {
        System.out.println("Common Mode \n");
        lights.forEach(light -> { System.out.println(light.operate());}) ;

        System.out.println(musicSystem.operate());
        musicSystem.setVolume(MusicVolume.LOW);

        System.out.println(thermostat.operate());

        securityCameras.forEach(SecurityCamera::stopRecording) ;

    }

    public void partyMode()
    {
        System.out.println("Party Mode \n");

        lights.forEach(light -> { light.changeState(LightState.DIM);}) ;

        System.out.println(musicSystem.operate());
        musicSystem.setVolume(MusicVolume.HIGH);

        thermostat.changeState(ThermostatState.PRODUCTIVE);

        securityCameras.forEach(SecurityCamera::stopRecording) ;
    }

    public void nightMode()
    {
        System.out.println("Night Mode \n");

        lights.forEach(light -> { light.changeState(LightState.OFF);}) ;

        musicSystem.stopPlaying();

        thermostat.changeState(ThermostatState.ECO);

        securityCameras.forEach(camera -> { System.out.println(camera.operate());}) ;

    }

    public void leaveHome()
    {
        System.out.println("Off Mode \n");

        lights.forEach(light -> { light.changeState(LightState.OFF);}) ;

        musicSystem.stopPlaying();

        thermostat.changeState(ThermostatState.OFF);

        securityCameras.forEach(camera -> { System.out.println(camera.operate());}) ;

    }
}
