package Sensor;

import java.util.List;

class Measurement {
    String name;
    Long date;
    List<Float> temperatures;

    public Measurement(String name, List<Float> temperature) {
        this.date = System.currentTimeMillis();
        this.name = name;
        this.temperatures = temperature;
    }
}
