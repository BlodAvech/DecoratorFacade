package LightTypes;

public class HalogenLamp implements LightType{
    @Override
    public String getType() {
        return "Halogen Lamp";
    }

    @Override
    public float getEnergyUseMultiplier() {
        return 3f;
    }
}
