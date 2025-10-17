package Builders;

import Devices.Light;
import LightTypes.Empty;
import LightTypes.LightType;

public class LightBuilder implements ILightBuilder {
    private final Light light;

    public LightBuilder()
    {
        light = new Light(new Empty());
    }

    public LightBuilder(Light light)
    {
        this.light = light;
    }

    @Override
    public void AddLightType(LightType lightType) {
        light.changeLightType(lightType);
    }

    @Override
    public Light build() {
        return light;
    }
}
