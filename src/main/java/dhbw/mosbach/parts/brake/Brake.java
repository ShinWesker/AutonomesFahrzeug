package dhbw.mosbach.parts.brake;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.events.brake.EventBrakeSet;

public class Brake extends ABrake {

    public void receive(EventBrakeSet eventBrakeSet) {
        percentage = eventBrakeSet.getPercentage();
        System.out.println("BrakeSet to: " + percentage);
    }
}
