package Devices;

import LightTypes.LightType;

public class Light implements Device {

    private boolean isTurnOn = false;
    private final LightType lightType;

    public Light(LightType lightType)
    {
        this.lightType = lightType;
    }

    @Override
    public String operate() {
        String log = "Light (" + lightType.getType() + ") " + (isTurnOn ? "already turned On" : "turned On");
        isTurnOn = true;
        return log;
    }

    public void turnOff()
    {
        isTurnOn = false;
        System.out.println("Light (" + getLightType().getType() + ") is turned Off");
    }

    public LightType getLightType() {
        return lightType;
    }
}
