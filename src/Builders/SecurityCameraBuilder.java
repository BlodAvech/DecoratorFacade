package Builders;

import Devices.SecurityCamera;

public class SecurityCameraBuilder implements ISecurityCamera{
    SecurityCamera securityCamera = new SecurityCamera();

    @Override
    public SecurityCamera build() {
        return securityCamera;
    }
}
