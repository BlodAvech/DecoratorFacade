package Devices;

public class TemperatureAndHumiditySensor implements Device{

    private float temperature = 24f;
    private float humidity = 15f;

    @Override
    public String operate() {
        return "Temp: " + temperature + "C | Hum: " + humidity + "%";
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
