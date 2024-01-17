package dhbw.mosbach;

import com.google.common.eventbus.EventBus;
import dhbw.mosbach.events.brake.EventBrakeLightOff;
import dhbw.mosbach.events.brake.EventBrakeLightOn;
import dhbw.mosbach.events.brake.EventBrakeSet;
import dhbw.mosbach.events.camera.EventCameraOff;
import dhbw.mosbach.events.camera.EventCameraOn;
import dhbw.mosbach.events.electricalengine.EventDecreaseRPM;
import dhbw.mosbach.events.electricalengine.EventEngineOff;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.electricalengine.EventIncreaseRPM;

public class CentralUnit {
    EventBus eventBus;
    public CentralUnit() {
        this.eventBus = new EventBus();
    }

    public void addSubscriber(Subscriber subscriber){
        eventBus.register(subscriber);
    }

    public void brakeLightsOn(){
        eventBus.post(new EventBrakeLightOn());
    }

    public void brakeLightsOff(){
        eventBus.post(new EventBrakeLightOff());
    }

    public void brakeSet(double percentage){
        eventBus.post(new EventBrakeSet(percentage));
    }

    public void cameraOn(){
        eventBus.post(new EventCameraOn());
    }

    public void cameraOff(){
        eventBus.post(new EventCameraOff());
    }

    public void engineOn() {
        eventBus.post(new EventEngineOn());
    }

    public void engineOff() {
        eventBus.post(new EventEngineOff());
    }

    public void engineIncreaseRPM(double deltaRPM, double seconds) {
        eventBus.post(new EventIncreaseRPM(deltaRPM,seconds));
    }

    public void engineDecreaseRPM(double deltaRPM, double seconds) {
        eventBus.post(new EventDecreaseRPM(deltaRPM,seconds));
    }
}
