package Devices;

public class SecurityCamera extends EnergyConsumer implements Device{
    private boolean isRecording = false;

    public SecurityCamera(float energyUse) {
        super(energyUse);
    }

    @Override
    public String operate() {
        String log = "Camera " + (isRecording ? "already recording" : "start recording");
        isRecording = true;
        return log;
    }


    public void stopRecording()
    {
        isRecording = false;
        System.out.println("Recording is Stop");
    }
}