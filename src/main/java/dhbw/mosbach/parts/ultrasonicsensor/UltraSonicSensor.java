package dhbw.mosbach.parts.ultrasonicsensor;

import java.util.ArrayList;
import java.util.List;

public class UltraSonicSensor {
    private List<IUltraSonicListener> listeners;

    private int id;


    public UltraSonicSensor(int id) {
        this.listeners = new ArrayList<>();
        this.id = id;
    }

    public void addListener(IUltraSonicListener listener){
        listeners.add(listener);
    }

    public void action(int minimalDistance){
        System.out.println("Sensor "+ id + " reported action!");
        for (IUltraSonicListener listener : listeners) {
            listener.reportObstacle(minimalDistance);
        }
    }
}
