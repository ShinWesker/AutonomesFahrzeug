package dhbw.mosbach.parts.battery;

public class BatteryEmptyException extends Exception{
    public BatteryEmptyException() {
        super("Battery is empty!");
    }
}
