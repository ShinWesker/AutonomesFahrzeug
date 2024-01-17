package dhbw.mosbach.parts.camera;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.camera.EventCameraOff;
import dhbw.mosbach.events.camera.EventCameraOn;

public class CameraV1 extends Subscriber implements ICamera {
    private boolean isOn;

    @Subscribe
    @Override
    public void receive(EventCameraOn eventCameraOn) {
        isOn = true;
        System.out.println("Camera on!");
    }

    @Subscribe
    @Override
    public void receive(EventCameraOff eventCameraOff) {
        isOn = false;
        System.out.println("Camera off!");

    }
    //TODO wird noch überarbeitet Template für dynamische komponente
}
