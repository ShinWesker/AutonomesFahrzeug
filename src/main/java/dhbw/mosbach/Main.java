package dhbw.mosbach;

import dhbw.mosbach.adapter.ChargingStation;
import dhbw.mosbach.adapter.FourPolAdapter;
import dhbw.mosbach.adapter.IConnectorPlug;
import dhbw.mosbach.adapter.TwoPolConnector;
import dhbw.mosbach.carconfiguration.AutonomousVehicleConfig;
import dhbw.mosbach.carconfiguration.VehicleConfigCLI;
import dhbw.mosbach.command.ICommand;
import dhbw.mosbach.command.Key;
import dhbw.mosbach.command.ShutdownCommand;
import dhbw.mosbach.command.StartupCommand;
import dhbw.mosbach.parts.battery.Battery;
import dhbw.mosbach.parts.battery.BatteryEmptyException;
import dhbw.mosbach.parts.brake.Brake;
import dhbw.mosbach.parts.brakelight.BrakeLight;
import dhbw.mosbach.parts.camera.CameraV1;
import dhbw.mosbach.parts.chassis.Chassis;
import dhbw.mosbach.parts.door.Door;
import dhbw.mosbach.parts.electricalengine.EngineConfig;
import dhbw.mosbach.parts.electricalengine.EngineController;
import dhbw.mosbach.parts.electricalengine.EngineX;
import dhbw.mosbach.parts.gps.GPS;
import dhbw.mosbach.parts.headlight.HeadLight;
import dhbw.mosbach.parts.lidar.LidarNG;
import dhbw.mosbach.parts.seatbench.SeatBench;
import dhbw.mosbach.parts.wheel.Wheel;

public class Main {
    public static void main(String[] args) {

        AutonomousVehicleConfig autonomousVehicleConfig = new AutonomousVehicleConfig();
        if (args.length > 0 && "-config".equals(args[0])) {
            // Code to start the configuration CLI
            new VehicleConfigCLI(autonomousVehicleConfig);
        }


        System.out.println("## Project Autonomous Vehicle ##");

        AutonomousVehicle vehicle = new AutonomousVehicle.Builder()
                .setChassis(new Chassis())
                .setEngine(new EngineController(EngineConfig.INSTANCE.getEngineType()))
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
                .setAutonomousVehicleConfig(autonomousVehicleConfig)
                .build();

        vehicle.startup();
        /*  vehicle.move(200, 20);
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
          // Observer - Pattern
          Battery battery = new Battery();

          try {
              battery.takeEnergy(1);
          } catch (BatteryEmptyException e) {
              System.out.println(e.getMessage());
          }

          battery.getBatteryTemperatureSensor().addListener(new CentralUnit());

          battery.charge();
          try {
              battery.takeEnergy(1);
          } catch (BatteryEmptyException e) {
              System.out.println(e.getMessage());
          }

          // key starting car
          Key key = new Key();
          ICommand cmd = new StartupCommand(key);
          key.setCommand(cmd);
          key.execute();


          // opening and closing the door
          vehicle.getLeftDoorSensor().action();
          vehicle.getRightDoorSensor().action();

          vehicle.getLeftDoorSensor().action();


          // detect near object Observer Pattern
          System.out.println();
          vehicle.getUltraSonicSensors()[5].action(5);

          // test emergency button
          vehicle.getEmergencyButton().press();
          */

        vehicle.move(100, 1);
    }
}