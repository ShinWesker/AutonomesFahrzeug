package dhbw.mosbach.parts.turnsignal;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.turnsignal.*;

public abstract class ATurnSignal extends Subscriber {

    protected boolean leftIndicator;
    protected boolean rightIndicator;
    protected boolean hazardIndicator;
    @Subscribe
    public abstract void receive(EventLeftIndicatorOn eventLeftIndicatorOn);
    @Subscribe
    public abstract void receive(EventLeftIndicatorOff eventLefIndicatorOff);
    @Subscribe
    public abstract void receive(EventRightIndicatorOn eventRightIndicatorOn);
    @Subscribe
    public abstract void receive(EventRightIndicatorOff eventRightIndicatorOff);
    @Subscribe
    public abstract void receive(EventHazardWarningOn eventHazardWarningOn);
    @Subscribe
    public abstract void receive(EventHazardWarningOff eventHazardWarningOff);

}
