package LightTypes;

public class IncandescentLamp implements LightType{
    @Override
    public String getType() {
        return "Incandescent Lamp";
    }

    @Override
    public float getEnergyUse() {
        return 400f;
    }
}