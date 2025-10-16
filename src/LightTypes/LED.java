package LightTypes;

public class LED implements LightType{
    @Override
    public String getType() {
        return "LED";
    }

    @Override
    public float getEnergyUse() {
        return 80f;
    }
}
