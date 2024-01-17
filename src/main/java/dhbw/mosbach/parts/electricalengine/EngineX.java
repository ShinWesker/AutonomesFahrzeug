package dhbw.mosbach.parts.electricalengine;

import dhbw.mosbach.events.electricalengine.EventDecreaseRPM;
import dhbw.mosbach.events.electricalengine.EventEngineOff;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.electricalengine.EventIncreaseRPM;

public class EngineX extends AEngine {
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

    @Override
    public void receive(EventIncreaseRPM eventIncreaseRPM) {
        RPM = eventIncreaseRPM.getDeltaRPM();
        seconds = eventIncreaseRPM.getSeconds();
        System.out.printf("""
                Engine RPM increased to:
                RPM: %.2f
                seconds: %.2f
                """, RPM, seconds);
    }

    @Override
    public void receive(EventDecreaseRPM eventDecreaseRPM) {
        RPM = eventDecreaseRPM.getDeltaRPM();
        seconds = eventDecreaseRPM.getSeconds();
        System.out.printf("""
                Engine RPM decreased to:
                RPM: %.2f
                seconds: %.2f
                """, RPM, seconds);

    }
    // TODO verhalten: verbraucht 4 Energieeinheiten/RPM je Iteration
}
