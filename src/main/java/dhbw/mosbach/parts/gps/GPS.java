package dhbw.mosbach.parts.gps;

import dhbw.mosbach.events.gps.EventGPSConnectSatellite;
import dhbw.mosbach.events.gps.EventGPSOff;
import dhbw.mosbach.events.gps.EventGPSOn;

public class GPS extends AGPS {
    @Override
    public void receive(EventGPSOn eventGPSOn) {
        isOn = true;
        System.out.println("GPS on!");
    }
    @Override
    public void receive(EventGPSOff eventGPSOff) {
        isOn = false;
        System.out.println("GPS off!");

    }
    @Override
    public void receive(EventGPSConnectSatellite eventGPSConnectSatellite) {
        frequency = eventGPSConnectSatellite.getFrequency();
        System.out.println("GPS frequency set to: " + frequency);

    }
}
