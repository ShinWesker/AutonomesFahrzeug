package dhbw.mosbach.parts.turnsignal;

import dhbw.mosbach.events.turnsignal.*;

public class TurnSignal extends ATurnSignal {
    @Override
    public void receive(EventLeftIndicatorOn eventLeftIndicatorOn) {
        leftIndicator = true;
        System.out.println("Left turn signal activated!");
    }

    @Override
    public void receive(EventLeftIndicatorOff eventLefIndicatorOff) {
        leftIndicator = false;
        System.out.println("Left turn signal deactivated!");
    }

    @Override
    public void receive(EventRightIndicatorOn eventRightIndicatorOn) {
        rightIndicator = true;
        System.out.println("Right turn signal on!");
    }

    @Override
    public void receive(EventRightIndicatorOff eventRightIndicatorOff) {
        rightIndicator = false;
        System.out.println("Right turn signal off!");
    }

    @Override
    public void receive(EventHazardWarningOn eventHazardWarningOn) {
        hazardIndicator = true;
        System.out.println("Turn singal HazardWarning on!");

    }

    @Override
    public void receive(EventHazardWarningOff eventHazardWarningOff) {
        hazardIndicator = false;
        System.out.println("Turn singal HazardWarning off!");
    }
}
