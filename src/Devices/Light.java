package Devices;

import Enums.LightState;
import LightTypes.LightType;

public class Light implements Device {

    private final LightType lightType;
    private LightState state = LightState.OFF;

    public Light(LightType lightType)
    {
        this.lightType = lightType;
    }

    @Override
    public String operate() {
        String log = "Light (" + lightType.getType() + ") state changed from " + state + " to " + LightState.BRIGHT;
        state = LightState.BRIGHT;
        return log;
    }

    public void changeState(LightState newState)
    {
        System.out.println("Light (" + lightType.getType() + ") state changed from " + state + " to " + newState);
        state = newState;
    }

    public LightType getLightType() {
        return lightType;
    }
}
