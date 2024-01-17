package dhbw.mosbach.parts.lidar;

import dhbw.mosbach.events.lidar.EventLidarOff;
import dhbw.mosbach.events.lidar.EventLidarOn;

public class LidarNG extends ALidar {
    @Override
    public void receive(EventLidarOn eventLidarOn) {
        isOn = true;
        System.out.println("Lidar on!");
    }
    @Override
    public void receive(EventLidarOff eventLidarOff) {
        isOn = false;
        System.out.println("Lidar off!");
    }
}
