package dhbw.mosbach.parts.brakelight;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.brake.EventBrakeLightOff;
import dhbw.mosbach.events.brake.EventBrakeLightOn;

public abstract class ABrakeLight extends Subscriber {
    protected boolean isOn;
    @Subscribe
    public abstract void receive(EventBrakeLightOn eventBrakeLightOn);
    @Subscribe
    public abstract void receive(EventBrakeLightOff eventBrakeLightOff);
}
