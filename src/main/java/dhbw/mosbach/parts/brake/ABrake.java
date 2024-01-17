package dhbw.mosbach.parts.brake;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.brake.EventBrakeSet;

public abstract class ABrake extends Subscriber {

    protected double percentage = 0;
    @Subscribe
    public abstract void receive(EventBrakeSet eventBrakeSet);
}
