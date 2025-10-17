package LightTypes;

public class Empty implements LightType {
    @Override
    public String getType() {
        return "Empty";
    }

    @Override
    public float getEnergyUse() {
        return 0;
    }
}
