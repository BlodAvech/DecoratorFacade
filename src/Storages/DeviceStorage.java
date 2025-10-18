package Storages;

import Devices.*;
import Facade.IoTFacade;

import java.util.ArrayList;
import java.util.List;


public class DeviceStorage
{
    private final List<Light> lights;
    private final MusicSystem musicSystem;
    private final Thermostat thermostat;
    private final List<SecurityCamera> cameras;
    private final IoTFacade facade;

    public DeviceStorage()
    {
        lights = new ArrayList<>();
        musicSystem = new MusicSystem();
        thermostat = new Thermostat();
        cameras = new ArrayList<>();
        facade = new IoTFacade(lights , musicSystem , thermostat , cameras);
    }

    public List<Light> getLights() {
        return lights;
    }

    public MusicSystem getMusicSystem() {
        return musicSystem;
    }

    public Thermostat getThermostat() {
        return thermostat;
    }

    public List<SecurityCamera> getCameras() {
        return cameras;
    }

    public void addNewLight(Light light)
    {
        lights.add(light);
    }

    public void addNewCamera(SecurityCamera camera)
    {
        cameras.add(camera);
    }

    public void removeCameraById(int id)
    {
        for (SecurityCamera camera : cameras)
        {
            if (camera.getId() == id)
            {
                cameras.remove(camera);
                System.out.println(camera.getId() + " has been removed");
                return;
            }
        }
        System.out.println("Camera with id " + id + " not found");
    }

    public void removeLightById(int id)
    {
        for (Light light : lights)
        {
            if (light.getId() == id)
            {
                lights.remove(light);
                System.out.println("Light with id " + id + " removed");
                return;
            }
        }
        System.out.println("Light with id " + id + " not found");
    }

    public Light getLightById(int id)
    {
        for (Light light : lights)
        {
            if (light.getId() == id)
            {
                return light;
            }
        }
        return null;
    }

    public SecurityCamera getCameraById(int id)
    {
        for (SecurityCamera camera : cameras)
        {
            if (camera.getId() == id)
            {
                return camera;
            }
        }
        return null;
    }

    public IoTFacade getFacade() {
        return facade;
    }
}
