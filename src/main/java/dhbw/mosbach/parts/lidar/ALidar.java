package dhbw.mosbach.parts.lidar;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.lidar.EventLidarOff;
import dhbw.mosbach.events.lidar.EventLidarOn;


public abstract class ALidar extends Subscriber {

    protected boolean isOn;
    @Subscribe
    public abstract void receive(EventLidarOn eventLidarOn);
    @Subscribe
    public abstract void receive(EventLidarOff eventLidarOff);
}
