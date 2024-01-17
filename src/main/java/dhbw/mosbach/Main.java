package dhbw.mosbach;

import dhbw.mosbach.adapter.ChargingStation;
import dhbw.mosbach.adapter.FourPolAdapter;
import dhbw.mosbach.adapter.IConnectorPlug;
import dhbw.mosbach.adapter.TwoPolConnector;
import dhbw.mosbach.parts.battery.Battery;
import dhbw.mosbach.parts.brake.Brake;
import dhbw.mosbach.parts.brakelight.BrakeLight;
import dhbw.mosbach.parts.camera.CameraV1;
import dhbw.mosbach.parts.chassis.Chassis;
import dhbw.mosbach.parts.door.Door;
import dhbw.mosbach.parts.electricalengine.EngineController;
import dhbw.mosbach.parts.electricalengine.EngineX;
import dhbw.mosbach.parts.gps.GPS;
import dhbw.mosbach.parts.headlight.HeadLight;
import dhbw.mosbach.parts.lidar.LidarNG;
import dhbw.mosbach.parts.seatbench.SeatBench;
import dhbw.mosbach.parts.wheel.Wheel;

public class Main {
    public static void main(String[] args) {
        System.out.println("## Project Autonomous Vehicle ##");

        AutonomousVehicle vehicle = new AutonomousVehicle.Builder()
                .setChassis(new Chassis())
                .setEngine(new EngineController(new EngineX()))
                .setBattery(new Battery())
                .setHeadLights(new HeadLight[]{new HeadLight(), new HeadLight(), new HeadLight(), new HeadLight()})
                .setBrakeLight(new BrakeLight[]{new BrakeLight(), new BrakeLight(), new BrakeLight(), new BrakeLight()})
                .setDoors(new Door[]{new Door(), new Door(), new Door(), new Door()})
                .setSeatBenchs(new SeatBench[]{new SeatBench(), new SeatBench()})
                .setWheels(new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()})
                .setBrakes(new Brake[]{new Brake(), new Brake(), new Brake(), new Brake()})
                .setGps(new GPS[]{new GPS(), new GPS()})
                .setCameras(new CameraV1[]{new CameraV1(), new CameraV1(), new CameraV1(), new CameraV1()})
                .setLidars(new LidarNG[]{new LidarNG(), new LidarNG(), new LidarNG(), new LidarNG()})
                .build();

        vehicle.startup();
        vehicle.move(200,20);
        vehicle.leftTurn(300, 4);
        vehicle.rightTurn(100, 3);
        vehicle.stop();
        vehicle.emergencyStop();
        vehicle.shutdown();


        // Adapter - Pattern
        IConnectorPlug twoPin = new TwoPolConnector();
        IConnectorPlug fourPin = new FourPolAdapter();

        ChargingStation chargingStation = new ChargingStation();
        chargingStation.connect(twoPin);
        chargingStation.connect(fourPin);

        // Composite - Pattern
        Battery battery = new Battery();
        boolean status = battery.takeEnergy(1);
        System.out.println(status);
        battery.charge();

        status = battery.takeEnergy(1);
        System.out.println(status);


    }
}