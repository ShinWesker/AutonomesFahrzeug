package dhbw.mosbach.parts.battery;

import java.util.ArrayList;
import java.util.List;

public class BatteryTemperatureSensor {

    private List<IBatteryTemperatureListener> listeners;

    public BatteryTemperatureSensor() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(IBatteryTemperatureListener listener){
        this.listeners.add(listener);
    }

    public void action(){
        for (IBatteryTemperatureListener listener : listeners) {
            listener.reportChange();
        }
    }

}
