package LightTypes;

public class LuminescentLamp implements LightType{
    @Override
    public String getType() {
        return "Luminescent Lamp";
    }

    @Override
    public float getEnergyUse() {
        return 150f;
    }
}
