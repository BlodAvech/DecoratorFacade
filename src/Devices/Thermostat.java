package Devices;

import Enums.ThermostatState;

import java.util.Random;

public class Thermostat extends EnergyConsumer implements Device{

    private float temperature = 22f;
    private ThermostatState state = ThermostatState.OFF;


    public Thermostat() {
        super(50f);
    }

    @Override
    public String operate() {
        state = ThermostatState.GENERAL;
        String log = "Thermostat start work" +  " State(" + state + ") ";
        return log + "\n" + "Temp: " + getTemperature() + "C";
    }

    @Override
    public String turnOf() {
        changeState(ThermostatState.OFF);
        return "Thermostat is turn Off";
    }


    public void changeState(ThermostatState newState)
    {
        System.out.println("Thermostat state changed from " + state + " to " + newState);
    }

    public void setTemperature(float temperature)
    {
        System.out.println("Temperature set from " + this.temperature + "C to "  + temperature + "C");
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

    @Override
    public EnergyConsumer getEnergyConsumer() {
        return this;
    }
}
