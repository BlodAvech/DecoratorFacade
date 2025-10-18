package Devices;

public class SecurityCamera extends EnergyConsumer implements Device{
    private static int id = 1;
    private final int cameraId;
    private boolean isRecording = false;

    public SecurityCamera() {
        super(100f);
        cameraId = id++;
    }

    @Override
    public String operate() {
        String log = "Camera #" + cameraId + " " + (isRecording ? "already recording" : "start recording");
        isRecording = true;
        return log;
    }

    @Override
    public String turnOf() {
        stopRecording();
        return "Security Camera #" + cameraId + " is turn Off";
    }


    public void stopRecording()
    {
        isRecording = false;
        System.out.println("Recording is Stop");
    }

    public int getId() {
        return cameraId;
    }

    public static int getMaxId() {return id;}

    @Override
    public EnergyConsumer getEnergyConsumer() {
        return this;
    }
}