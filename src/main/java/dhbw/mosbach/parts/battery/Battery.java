package dhbw.mosbach.parts.battery;

public class Battery {
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

    public boolean takeEnergy(int amount){
        setTemperature(temperature - 5);
        if (amount < 0)  return true;
        for (ACell subordinate : cells) {
            if (amount == 0) return true;
            amount = subordinate.discharge(amount);
        }
        return amount == 0;
    }

    public void charge(){
        setTemperature(temperature + 5);
        for (ACell subordinate : cells) {
            subordinate.charge();
        }
    }

    private void setTemperature(int temperature) {
        batteryTemperatureSensor.action();
        this.temperature = temperature;
    }
}
