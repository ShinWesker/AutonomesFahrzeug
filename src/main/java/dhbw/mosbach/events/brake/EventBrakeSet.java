package dhbw.mosbach.events.brake;

public class EventBrakeSet {
    private final double percentage;
    public EventBrakeSet(double percentage) {
        this.percentage = percentage;
    }
    public double getPercentage() {
        return percentage;
    }
}
