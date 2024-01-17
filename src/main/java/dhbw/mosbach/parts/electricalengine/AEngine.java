package dhbw.mosbach.parts.electricalengine;

import dhbw.mosbach.events.electricalengine.EventDecreaseRPM;
import dhbw.mosbach.events.electricalengine.EventEngineOff;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.electricalengine.EventIncreaseRPM;

public abstract class AEngine {

    protected double RPM;
    protected double seconds;
    protected boolean isOn;

    public abstract void receive(EventEngineOn eventEngineOn);

    public abstract void receive(EventEngineOff eventEngineOff);

    public abstract void receive(EventIncreaseRPM eventIncreaseRPM);
    public abstract void receive(EventDecreaseRPM eventDecreaseRPM);
}
