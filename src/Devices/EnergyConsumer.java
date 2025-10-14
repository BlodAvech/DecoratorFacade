package Devices;

public class EnergyConsumer {
    private float energyUse; //kWh

    public EnergyConsumer(float energyUse)
    {
        this.energyUse = energyUse;
    }

    public float getEnergyUse() {
        return energyUse;
    }

    public void setEnergyUse(float energyUse) {
        this.energyUse = energyUse;
    }

    public void getInfo()
    {
        System.out.println("This Device use " + energyUse + "kWh");
    }
}
