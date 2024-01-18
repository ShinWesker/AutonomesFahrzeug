package dhbw.mosbach.parts.electricalengine;

import com.google.common.eventbus.EventBus;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.battery.EventBatteryTakeEnergy;
import dhbw.mosbach.events.electricalengine.EventDecreaseRPM;
import dhbw.mosbach.events.electricalengine.EventEngineOff;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.electricalengine.EventIncreaseRPM;

public abstract class AEngine {

    protected EventBus eventBus;
    protected double RPM;
    protected double seconds;
    protected boolean isOn;

    protected int energyUsageFactor;

    public AEngine() {
        this.eventBus = new EventBus();
    }

    public abstract void receive(EventEngineOn eventEngineOn);

    public abstract void receive(EventEngineOff eventEngineOff);

    public void receive(EventIncreaseRPM eventIncreaseRPM) {
        RPM = eventIncreaseRPM.getDeltaRPM() + RPM;

        seconds = eventIncreaseRPM.getSeconds();
        System.out.printf("""
                Engine RPM increased to:
                RPM: %.2f
                seconds: %.2f
                """, RPM, seconds);

        while (seconds > 0) {
            eventBus.post(new EventBatteryTakeEnergy((int) RPM * this.energyUsageFactor));
            seconds--;
        }
    }


    public void receive(EventDecreaseRPM eventDecreaseRPM) {
        RPM = RPM - eventDecreaseRPM.getDeltaRPM() >= 0 ? RPM - eventDecreaseRPM.getDeltaRPM() : 0;

        seconds = eventDecreaseRPM.getSeconds();
        System.out.printf("""
                Engine RPM decreased to:
                RPM: %.2f
                seconds: %.2f
                """, RPM, seconds);

        while (seconds > 0) {
            eventBus.post(new EventBatteryTakeEnergy((int) RPM * this.energyUsageFactor));
            seconds--;
        }

    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }


}
