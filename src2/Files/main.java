import Sensor.Sensor;

public class main {

    public static void main(String[] args) {
        Sensor s = new Sensor("MyAwesomeSensor", new FileOutput((Listener) new ReadFileListener()));
        for (int i = 0; i < 10; i++) {
            s.measure();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //No Handler
            }
        }
    }
}
