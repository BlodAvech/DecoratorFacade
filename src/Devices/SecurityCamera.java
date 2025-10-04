package Devices;

public class SecurityCamera implements Device{
    private boolean isRecording = false;

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
