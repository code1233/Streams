package SensorData;


import filepersistence.WriteAndReadDataSet;
import transmission.DataConnection;

import java.io.IOException;

public class SensorDataSender {

    private WriteAndReadDataSet sensoranliegen;
    private final DataConnection connection;

    public SensorDataSender(DataConnection connection) {

        this.connection = connection;
    }

    public void sendData(String name, long time, float[] values) throws IOException {
        // TODO
    }
}