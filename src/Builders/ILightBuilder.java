package Builders;

import Devices.Light;
import LightTypes.LightType;

public interface ILightBuilder {
    public abstract void AddLightType(LightType lightType);
    public abstract Light build();
}
