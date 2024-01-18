package dhbw.mosbach.events.battery;

public class EventBatteryTakeEnergy {

    private final int amount;

    public EventBatteryTakeEnergy(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
