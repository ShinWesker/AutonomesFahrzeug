package dhbw.mosbach.parts.camera;

import com.google.common.eventbus.Subscribe;
import dhbw.mosbach.JsonConfig;
import dhbw.mosbach.Subscriber;
import dhbw.mosbach.events.camera.EventCameraOff;
import dhbw.mosbach.events.camera.EventCameraOn;

import java.lang.reflect.Method;

public class CameraHandler extends Subscriber implements ICamera {
    private boolean isOn;

    private Object camera;

    public CameraHandler(){
        camera = JsonConfig.INSTANCE.getCamera();
    }

    @Subscribe
    @Override
    public void receive(EventCameraOn eventCameraOn) {
        try {
            Method cameraOn = camera.getClass().getMethod("on");
            cameraOn.invoke(camera);
        } catch (Exception e) {
            System.out.println("--- exception");
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    @Override
    public void receive(EventCameraOff eventCameraOff) {
        try {
            Method cameraOff = camera.getClass().getMethod("off");
            cameraOff.invoke(camera);
        } catch (Exception e) {
            System.out.println("--- exception");
            System.out.println(e.getMessage());
        }
    }
}
