package dhbw.mosbach;

import dhbw.mosbach.parts.brake.ABrake;
import dhbw.mosbach.parts.brake.Brake;
import dhbw.mosbach.parts.brakelight.ABrakeLight;
import dhbw.mosbach.parts.brakelight.BrakeLight;
import dhbw.mosbach.parts.camera.CameraV1;
import dhbw.mosbach.parts.camera.ICamera;
import dhbw.mosbach.parts.electricalengine.AEngine;
import dhbw.mosbach.parts.electricalengine.EngineX;

public class Main {
    public static void main(String[] args) {
        System.out.println("Project autonomous vehicle");

        CentralUnit centralUnit = new CentralUnit();
        /*
        // Method I Interface extends die einzelne Klasse

        ICamera camera = new CameraV1();
        centralUnit.addSubscriber((Subscriber) camera);

        centralUnit.cameraOn();
        centralUnit.cameraOff();
         */


        ABrake brake = new Brake();
        ABrakeLight brakeLight = new BrakeLight();
        AEngine engine = new EngineX();

        centralUnit.addSubscriber(brakeLight);
        centralUnit.addSubscriber(brake);
        centralUnit.addSubscriber(engine);

        // Über Facade Autonomous Vehicle
        AutonomousVehicle autonomousVehicle = new AutonomousVehicle(centralUnit);
        autonomousVehicle.startup();
    }
}