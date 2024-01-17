package dhbw.mosbach.parts.headlight;

import dhbw.mosbach.events.headlight.EventLEDDimmed;
import dhbw.mosbach.events.headlight.EventLEDHighBeam;
import dhbw.mosbach.events.headlight.EventLEDOff;
import dhbw.mosbach.events.headlight.EventLEDOn;

public class HeadLight extends AHeadLight {
    @Override
    public void receive(EventLEDOn eventLEDOn) {
        isOn = true;
        System.out.println("HeadLight on!");

    }

    @Override
    public void receive(EventLEDOff eventLEDOff) {
        isOn = false;
        System.out.println("HeadLight off!");
    }

    @Override
    public void receive(EventLEDDimmed eventLEDDimmed) {
        System.out.println("HeadLight dimmed on!");
    }

    @Override
    public void receive(EventLEDHighBeam eventLEDHighBeam) {
        System.out.println("HeadLight HighBeam on!");
    }
}
