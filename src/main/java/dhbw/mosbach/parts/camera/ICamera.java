package dhbw.mosbach.parts.camera;

import dhbw.mosbach.events.camera.EventCameraOff;
import dhbw.mosbach.events.camera.EventCameraOn;

public interface ICamera {

    public void receive(EventCameraOn eventCameraOn);
    public void receive(EventCameraOff eventCameraOff);
}
