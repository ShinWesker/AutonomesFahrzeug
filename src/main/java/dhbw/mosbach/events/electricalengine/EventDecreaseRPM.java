package dhbw.mosbach.events.electricalengine;

public class EventDecreaseRPM {
    private final double deltaRPM;
    private final double seconds;
    public EventDecreaseRPM(double deltaRPM, double seconds1) {
        this.deltaRPM = deltaRPM;
        this.seconds = seconds1;
    }
    public double getDeltaRPM() {
        return deltaRPM;
    }

    public double getSeconds() {
        return seconds;
    }
}
