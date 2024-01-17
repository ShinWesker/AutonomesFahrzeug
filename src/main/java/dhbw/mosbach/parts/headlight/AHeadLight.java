package dhbw.mosbach.parts.headlight;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.headlight.EventLEDDimmed;
import dhbw.mosbach.events.headlight.EventLEDHighBeam;
import dhbw.mosbach.events.headlight.EventLEDOff;
import dhbw.mosbach.events.headlight.EventLEDOn;

public abstract class AHeadLight extends Subscriber {
    protected boolean isOn;

    @Subscribe
    public abstract void receive(EventLEDOn eventLEDOn);

    @Subscribe
    public abstract void receive(EventLEDOff eventLEDOff);

    @Subscribe
    public abstract void receive(EventLEDDimmed eventLEDDimmed);

    @Subscribe
    public abstract void receive(EventLEDHighBeam eventLEDHighBeam);
}
