package Decorators;

import Devices.Device;
import Devices.EnergyConsumer;

public class EnergySavingDecorator extends DeviceDecorator{

    private float energyMultiplier = .6f;
    private final EnergyConsumer energyConsumer;
    public EnergySavingDecorator(Device device , EnergyConsumer energyConsumer) {
        super(device);
        this.energyConsumer = energyConsumer;
        }

    @Override
    public String operate() {
        return getDevice().operate() + "with Energy Saving ";
    }

    @Override
    public String turnOf() {
        return getDevice().turnOf();
    }

    @Override
    public void saveEnergy() {
        float reducedEnergy = energyConsumer.getEnergyUse() * energyMultiplier;
        System.out.println("Energy Reduced from " + energyConsumer.getEnergyUse() + "kWh to " + reducedEnergy + "kWh");
        energyConsumer.setEnergyUse(reducedEnergy);
    }

}
