package Devices;

import Enums.ThermostatState;

import java.util.Random;

public class Thermostat extends EnergyConsumer implements Device{

    private final float temperature = 22f;
    private final float humidity = 45f;
    private ThermostatState state = ThermostatState.OFF;

    private Random rnd = new Random();

    public Thermostat(float energyUse) {
        super(energyUse);
    }

    @Override
    public String operate() {
        state = ThermostatState.GENERAL;
        String log = "Thermostat start work" +  " State(" + state + ") ";
        return log + "\n" + "Temp: " + getTemperature() + "C | Hum: " + getHumidity() + "%";
    }


    public void changeState(ThermostatState newState)
    {
        System.out.println("Thermostat state changed from " + state + " to " + newState);
    }

    public float getTemperature() {
        return temperature * rnd.nextFloat(.9f ,1.1f);
    }

    public float getHumidity() {
        return humidity * rnd.nextFloat(.9f ,1.1f);
    }

}
