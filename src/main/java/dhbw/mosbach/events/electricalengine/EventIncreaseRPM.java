package dhbw.mosbach.events.electricalengine;

public class EventIncreaseRPM {

    private final double deltaRPM;
    private final double seconds;
    public EventIncreaseRPM(double deltaRPM, double seconds) {
        this.deltaRPM = deltaRPM;
        this.seconds = seconds;
    }

    public double getDeltaRPM() {
        return deltaRPM;
    }

    public double getSeconds() {
        return seconds;
    }
}
