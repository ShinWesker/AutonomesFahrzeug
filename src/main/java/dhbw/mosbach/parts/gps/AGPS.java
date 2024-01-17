package dhbw.mosbach.parts.gps;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.gps.EventGPSConnectSatellite;
import dhbw.mosbach.events.gps.EventGPSOff;
import dhbw.mosbach.events.gps.EventGPSOn;

public abstract class AGPS extends Subscriber {
    protected boolean isOn;
    protected String frequency;
    @Subscribe
    public abstract void receive(EventGPSOn eventGPSOn);
    @Subscribe
    public abstract void receive(EventGPSOff eventGPSOff);
    @Subscribe
    public abstract void receive(EventGPSConnectSatellite eventGPSConnectSatellite);
}
