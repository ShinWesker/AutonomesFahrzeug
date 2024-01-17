package dhbw.mosbach.events.gps;

public class EventGPSConnectSatellite {
    public final String frequency;
    public EventGPSConnectSatellite(String frequency) {
        this.frequency = frequency;
    }

    public String getFrequency() {
        return frequency;
    }
}
