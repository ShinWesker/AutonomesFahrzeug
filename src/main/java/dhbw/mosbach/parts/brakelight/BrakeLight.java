package dhbw.mosbach.parts.brakelight;

import dhbw.mosbach.events.brake.EventBrakeLightOff;
import dhbw.mosbach.events.brake.EventBrakeLightOn;

public class BrakeLight extends ABrakeLight {

    @Override
    public void receive(EventBrakeLightOn eventBrakeLightOn) {
        isOn = true;
        System.out.println("Brake light on!");
    }

    @Override
    public void receive(EventBrakeLightOff eventBrakeLightOff) {
        isOn = false;
        System.out.println("Brake light off!");
    }
}
