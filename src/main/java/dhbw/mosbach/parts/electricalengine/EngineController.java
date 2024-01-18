package dhbw.mosbach.parts.electricalengine;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.electricalengine.EventDecreaseRPM;
import dhbw.mosbach.events.electricalengine.EventEngineOff;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.electricalengine.EventIncreaseRPM;

public class EngineController extends Subscriber {
    private AEngine engine;

    public EngineController(AEngine aEngine){
        this.engine = aEngine;
    }
    @Subscribe
    public  void receive(EventEngineOn eventEngineOn){
        engine.receive(eventEngineOn);
    }
    @Subscribe
    public  void receive(EventEngineOff eventEngineOff){
        engine.receive(eventEngineOff);
    }
    @Subscribe
    public  void receive(EventIncreaseRPM eventIncreaseRPM){
        engine.receive(eventIncreaseRPM);
    }
    @Subscribe
    public  void receive(EventDecreaseRPM eventDecreaseRPM){
        engine.receive(eventDecreaseRPM);
    }

    public void addSubscriber(Subscriber subscriber){
        this.engine.addSubscriber(subscriber);
    }
}

