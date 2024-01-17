package dhbw.mosbach.parts.electricalengine;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.electricalengine.EventDecreaseRPM;
import dhbw.mosbach.events.electricalengine.EventEngineOff;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.electricalengine.EventIncreaseRPM;

public abstract class AEngine extends Subscriber {

    protected double RPM;
    protected double seconds;
    protected boolean isOn;

    @Subscribe
    public abstract void receive(EventEngineOn eventEngineOn);
    @Subscribe
    public abstract void receive(EventEngineOff eventEngineOff);
    @Subscribe
    public abstract void receive(EventIncreaseRPM eventIncreaseRPM);
    @Subscribe
    public abstract void receive(EventDecreaseRPM eventDecreaseRPM);
}
