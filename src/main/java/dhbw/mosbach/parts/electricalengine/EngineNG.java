package dhbw.mosbach.parts.electricalengine;

import dhbw.mosbach.events.battery.EventBatteryTakeEnergy;
import dhbw.mosbach.events.electricalengine.EventDecreaseRPM;
import dhbw.mosbach.events.electricalengine.EventEngineOff;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.electricalengine.EventIncreaseRPM;

public class EngineNG extends AEngine {
    public EngineNG() {
        super();
        this.energyUsageFactor = 3;
    }
    @Override
    public void receive(EventEngineOn eventEngineOn) {
        isOn = true;
        System.out.println("Engine started!");
    }

    @Override
    public void receive(EventEngineOff eventEngineOff) {
        isOn = false;
        System.out.println("Engine stopped!");

    }




}
