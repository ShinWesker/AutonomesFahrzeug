package dhbw.mosbach.parts.doorsensor;

import dhbw.mosbach.parts.door.DoorSide;

import java.util.ArrayList;
import java.util.List;

public class DoorSensor {
    private List<IDoorListener> listeners;

    private final DoorSide doorSide;

    public DoorSensor(DoorSide doorSide) {
        this.listeners = new ArrayList<>();
        this.doorSide = doorSide;
    }

    public void addListener(IDoorListener listener){
        this.listeners.add(listener);
    }

    public void action(){
        System.out.println(doorSide.toString());
        for (IDoorListener listener : listeners) {
            listener.openDoor(this.doorSide);
        }
    }
}
