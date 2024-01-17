package dhbw.mosbach;

import dhbw.mosbach.parts.brake.ABrake;
import dhbw.mosbach.parts.brake.Brake;
import dhbw.mosbach.parts.brakelight.ABrakeLight;
import dhbw.mosbach.parts.brakelight.BrakeLight;
import dhbw.mosbach.parts.camera.CameraV1;
import dhbw.mosbach.parts.camera.ICamera;
import dhbw.mosbach.parts.electricalengine.AEngine;
import dhbw.mosbach.parts.electricalengine.EngineX;
import dhbw.mosbach.parts.gps.AGPS;
import dhbw.mosbach.parts.gps.GPS;
import dhbw.mosbach.parts.headlight.AHeadLight;
import dhbw.mosbach.parts.headlight.HeadLight;
import dhbw.mosbach.parts.lidar.ALidar;
import dhbw.mosbach.parts.lidar.LidarNG;
import dhbw.mosbach.parts.turnsignal.ATurnSignal;
import dhbw.mosbach.parts.turnsignal.TurnSignal;

public class Main {
    public static void main(String[] args) {
        System.out.println("## Project Autonomous Vehicle ##");

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
        AHeadLight headLight = new HeadLight();
        ATurnSignal turnSignal = new TurnSignal();
        AGPS agps = new GPS();
        ALidar lidar = new LidarNG();

        centralUnit.addSubscriber(brakeLight);
        centralUnit.addSubscriber(brake);
        centralUnit.addSubscriber(engine);
        centralUnit.addSubscriber(headLight);
        centralUnit.addSubscriber(turnSignal);
        centralUnit.addSubscriber(agps);
        centralUnit.addSubscriber(lidar);

        // Über Facade Autonomous Vehicle
        AutonomousVehicle autonomousVehicle = new AutonomousVehicle(centralUnit);
        autonomousVehicle.startup();
        autonomousVehicle.move(200,20);
        autonomousVehicle.leftTurn(300, 4);
        autonomousVehicle.rightTurn(100, 3);
        autonomousVehicle.stop();
        autonomousVehicle.emergencyStop();
        autonomousVehicle.shutdown();
    }
}