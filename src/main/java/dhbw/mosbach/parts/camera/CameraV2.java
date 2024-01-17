package dhbw.mosbach.parts.camera;

import dhbw.mosbach.events.camera.EventCameraOff;
import dhbw.mosbach.events.camera.EventCameraOn;

public class CameraV2 implements ICamera {
    private boolean isOn;
    @Override
    public void receive(EventCameraOn eventCameraOn) {
        isOn = true;
        System.out.println("Camera on!");
    }

    @Override
    public void receive(EventCameraOff eventCameraOff) {
        isOn = false;
        System.out.println("Camera off!");

    }
}
