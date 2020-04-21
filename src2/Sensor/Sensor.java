package Sensor;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sensor {
    String name;
    private Measurement currentMeasurement;
    private float previousTemprature;
    private FileOutput fileOutput;

    public Sensor(String name, FileOutput fileOutput) {
        this.name = name;
        this.fileOutput = fileOutput;
    }


    private void addTemp(float newValue) {
        if (currentMeasurement == null) {
            // if first measurment
            System.out.println("Adding first value to measurement");
            List<Float> newList = new ArrayList<Float>();
            newList.add(newValue);
            currentMeasurement = new Measurement(this.name, newList);
        } else {
            System.out.println("Measurement difference less than 1 degree. Adding value to measurement.");
            currentMeasurement.temperatures.add(newValue);
            currentMeasurement.date = System.currentTimeMillis();
        }
    }

    public void measure() {
        // int howManyValues =  new Random().nextInt(5) + 1;
        float newValue = (float) (Math.random() + 0.1) * 10;
        if (previousTemprature != 0 && Math.abs(previousTemprature - newValue) >= 1) {
            System.out.println("Measurement difference larger than 1 degree. Printing to file...");
            addTemp(newValue);
            // Print to file
            this.writeToFile(currentMeasurement);
            currentMeasurement = null; // empty
        } else {
            addTemp(newValue);
        }
        previousTemprature = newValue;
    }

    private void writeToFile(Measurement m) {
        System.out.println("Writing to file...");
        String toPrint = "-Name: " + m.name + ". -Date: " + new Date(m.date).toString() + ". -Values: ";
        for (float f : m.temperatures) {
            toPrint += f + " ";
        }
        this.fileOutput.addRecords(toPrint);
    }
}
