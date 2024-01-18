package dhbw.mosbach.parts.battery;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.battery.EventBatteryTakeEnergy;

import java.util.concurrent.Flow;

public class Battery extends Subscriber {
    private final ACell[] cells;
    private int temperature;

    private final BatteryTemperatureSensor batteryTemperatureSensor;

    public BatteryTemperatureSensor getBatteryTemperatureSensor() {
        return batteryTemperatureSensor;
    }

    public Battery(){
        cells = new MainCell[500];

        for (int i = 0; i < cells.length; i++) {
            cells[i] = new MainCell();

            for (int j = 0; j < 100 ; j++) {
                ACell subCell = new SubCell();

                for (int k = 0; k < 5; k++) {
                    ACell cell = new Cell();
                    subCell.addUnit(cell);
                }
                cells[i].addUnit(subCell);
            }
        }
        this.batteryTemperatureSensor = new BatteryTemperatureSensor();

    }

    @Subscribe
    public void takeEnergy(EventBatteryTakeEnergy eventBatteryTakeEnergy) throws BatteryEmptyException {
        int amount = eventBatteryTakeEnergy.getAmount();
        if (amount< 0)  return;
        for (ACell subordinate : cells) {
            if (amount == 0) return;
            amount = subordinate.discharge(amount);
            setTemperature(temperature - 5);
        }
        if (amount != 0) throw new BatteryEmptyException();
    }

    public void charge(){
        for (ACell subordinate : cells) {
            subordinate.charge();
            setTemperature(temperature + 5);
        }
    }

    private void setTemperature(int temperature) {
        batteryTemperatureSensor.action();
        this.temperature = temperature;
    }
}
