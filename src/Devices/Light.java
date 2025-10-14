package Devices;

import Enums.LightState;
import LightTypes.HalogenLamp;
import LightTypes.LightType;

public class Light extends EnergyConsumer implements Device {

    private final LightType lightType;
    private LightState state = LightState.OFF;

    public Light(LightType lightType , float energyUse)
    {
        super(energyUse * lightType.getEnergyUseMultiplier());
        this.lightType = lightType;
    }

    @Override
    public String operate() {
        String log = "Light (" + lightType.getType() + ") state changed from " + state + " to " + LightState.BRIGHT;
        state = LightState.BRIGHT;
        return log;
    }

    @Override
    public String turnOf() {
        changeState(LightState.OFF);
        return "Light is turn Off";
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
