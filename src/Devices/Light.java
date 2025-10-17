package Devices;

import Enums.LightState;
import LightTypes.Empty;
import LightTypes.HalogenLamp;
import LightTypes.LightType;

import java.util.Objects;

public class Light extends EnergyConsumer implements Device
{
    private static int id = 1;
    private final int lightId;

    private LightType lightType = new Empty();
    private LightState state = LightState.OFF;


    public Light(LightType lightType)
    {
        super(lightType.getEnergyUse());
        this.lightType = lightType;

        lightId = id++;
    }
    public Light()
    {
        super(0);

        lightId = id++;
    }

    @Override
    public String operate() {
        String log;
        if(Objects.equals(lightType.getType(), "Empty"))
        {
            log = "Light #" + lightId +  " (" + lightType.getType() + ") is Empty";
            return log;
        }
        log = "Light #" + lightId +  " (" + lightType.getType() + ") state changed from " + state + " to " + LightState.NORMAL;
        state = LightState.NORMAL;
        return log;
    }

    @Override
    public String turnOf() {
        changeState(LightState.OFF);
        return "Light #" + lightId + " is turn Off";
    }

    @Override
    public float getEnergyUse()
    {
        return lightType.getEnergyUse();
    }

    public void changeState(LightState newState)
    {
        System.out.println("Light #" + lightId + " (" + lightType.getType() + ") state changed from " + state + " to " + newState);
        state = newState;
        setEnergyUse(lightType.getEnergyUse());
    }

    public void changeLightType(LightType lightType)
    {
        System.out.println("Light #" + lightId + " type changed from " + this.lightType.getType() + " to " + lightType.getType());
        this.lightType = lightType;
    }

    public LightType getLightType() {
        return lightType;
    }

    public int getId() {
        return lightId;
    }

    public static int getMaxId() {return id;}
}
