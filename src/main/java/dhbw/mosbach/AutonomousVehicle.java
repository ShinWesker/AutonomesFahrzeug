package dhbw.mosbach;

import dhbw.mosbach.carconfiguration.AutonomousVehicleConfig;
import dhbw.mosbach.command.DoorChangeStateCommand;
import dhbw.mosbach.command.ICommand;
import dhbw.mosbach.parts.battery.Battery;
import dhbw.mosbach.parts.brake.ABrake;
import dhbw.mosbach.parts.brakelight.ABrakeLight;
import dhbw.mosbach.parts.doorsensor.DoorSensor;
import dhbw.mosbach.parts.doorsensor.IDoorListener;
import dhbw.mosbach.parts.camera.ICamera;
import dhbw.mosbach.parts.chassis.IChassis;
import dhbw.mosbach.parts.door.Door;
import dhbw.mosbach.parts.door.DoorSide;
import dhbw.mosbach.parts.electricalengine.EngineController;
import dhbw.mosbach.parts.emergencybutton.EmergencyButton;
import dhbw.mosbach.parts.gps.AGPS;
import dhbw.mosbach.parts.headlight.AHeadLight;
import dhbw.mosbach.parts.lidar.ALidar;
import dhbw.mosbach.parts.seatbench.SeatBench;
import dhbw.mosbach.parts.ultrasonicsensor.UltraSonicSensor;
import dhbw.mosbach.parts.wheel.IWheel;

public class AutonomousVehicle implements IDoorListener {

    private IChassis chassis;
    private EngineController engine;
    private Battery battery;
    private AHeadLight[] headLights;
    private ABrakeLight[] brakeLight;
    private Door[] doors;
    private SeatBench[] seatBenchs;
    private IWheel[] wheels;
    private ABrake[] brakes;
    private AGPS[] gps;
    private ICamera[] cameras;
    private ALidar[] lidars;
    private CentralUnit centralUnit;

    private DoorSensor leftDoorSensor;
    private DoorSensor rightDoorSensor;

    private UltraSonicSensor[] ultraSonicSensors;

    private AutonomousVehicleConfig autonomousVehicleConfig;

    private EmergencyButton emergencyButton;

    public DoorSensor getLeftDoorSensor() {
        return leftDoorSensor;
    }

    public DoorSensor getRightDoorSensor() {
        return rightDoorSensor;
    }

    public UltraSonicSensor[] getUltraSonicSensors() {
        return ultraSonicSensors;
    }

    public EmergencyButton getEmergencyButton() {
        return emergencyButton;
    }

    private AutonomousVehicle(Builder builder) {
        this.centralUnit = builder.centralUnit;
        this.chassis = builder.chassis;
        this.engine = builder.engine;
        this.battery = builder.battery;
        this.headLights = builder.headLights;
        this.brakeLight = builder.brakeLight;
        this.doors = builder.doors;
        this.seatBenchs = builder.seatBenchs;
        this.wheels = builder.wheels;
        this.brakes = builder.brakes;
        this.gps = builder.gps;
        this.cameras = builder.cameras;
        this.lidars = builder.lidars;
        this.autonomousVehicleConfig = builder.autonomousVehicleConfig;

        this.centralUnit.setVehicle(this);

        this.leftDoorSensor = new DoorSensor(DoorSide.LEFT);
        leftDoorSensor.addListener(this);
        this.rightDoorSensor = new DoorSensor(DoorSide.RIGHT);
        rightDoorSensor.addListener(this);
        battery.getBatteryTemperatureSensor().addListener(centralUnit);


        // security relevant sensors are hard coded
        ultraSonicSensors = new UltraSonicSensor[8];
        for (int i = 0; i < ultraSonicSensors.length; i++) {
            ultraSonicSensors[i] = new UltraSonicSensor(i);
            ultraSonicSensors[i].addListener(centralUnit);
        }

        emergencyButton = new EmergencyButton();


    }

    public void startup() {
        System.out.println("Start: ");
        centralUnit.engineOn();
        centralUnit.ledOn();
        centralUnit.gpsConnectSatellite("118.75");
        centralUnit.cameraOn();
        centralUnit.lidarOn();
        centralUnit.turnSignalLeftOn();
        System.out.println();
    }

    public void move(double deltaRPM, double seconds) {
        System.out.println("Move: ");
        centralUnit.turnSignalLeftOff();
        centralUnit.turnSignalRightOff();
        centralUnit.ledDimmed();
        centralUnit.engineIncreaseRPM(deltaRPM, seconds);
        centralUnit.brakeSet(0);
        centralUnit.brakeLightsOff();
        System.out.println();
    }

    public void leftTurn(double deltaRPM, double seconds) {
        System.out.println("Turn left: ");
        centralUnit.turnSignalLeftOn();
        centralUnit.engineDecreaseRPM(deltaRPM, seconds);
        centralUnit.brakeSet(70);
        centralUnit.brakeLightsOn();
        System.out.println();

    }

    public void rightTurn(double deltaRPM, double seconds) {
        System.out.println("Turn right: ");
        centralUnit.turnSignalRightOn();
        centralUnit.engineDecreaseRPM(deltaRPM, seconds);
        centralUnit.brakeSet(70);
        centralUnit.brakeLightsOn();
        System.out.println();

    }

    public void stop() {
        System.out.println("Stop: ");
        centralUnit.brakeSet(100);
        centralUnit.brakeLightsOn();
        System.out.println();

    }

    public void emergencyStop() {
        System.out.println("Emergency stop: ");
        centralUnit.brakeSet(100);
        centralUnit.brakeLightsOn();
        centralUnit.turnSignalHazardWarningOn();
        centralUnit.engineOff();
        centralUnit.ledHighBeam();
        centralUnit.cameraOff();
        centralUnit.lidarOff();
        System.out.println();
    }

    public void shutdown() {
        System.out.println("Shutdown: ");
        centralUnit.brakeSet(100);
        centralUnit.engineOff();
        centralUnit.brakeLightsOff();
        centralUnit.ledOff();
        centralUnit.turnSignalHazardWarningOff();
        centralUnit.gpsOff();
        centralUnit.cameraOff();
        centralUnit.lidarOff();
        System.out.println();
    }

    @Override
    public void openDoor(DoorSide doorSide) {
        if (doorSide == DoorSide.LEFT) {
            executeCommandOnDoors(0, 1);
        } else if (doorSide == DoorSide.RIGHT) {
            executeCommandOnDoors(2, 3);
        }
    }

    private void executeCommandOnDoors(int firstDoorIndex, int secondDoorIndex) {
        ICommand cmd = new DoorChangeStateCommand(doors[firstDoorIndex]);
        cmd.execute();
        cmd = new DoorChangeStateCommand(doors[secondDoorIndex]);
        cmd.execute();
    }


    public static class Builder {
        private CentralUnit centralUnit = new CentralUnit();
        private IChassis chassis;
        private EngineController engine;
        private Battery battery;
        private AHeadLight[] headLights;
        private ABrakeLight[] brakeLight;
        private Door[] doors;
        private SeatBench[] seatBenchs;
        private IWheel[] wheels;
        private ABrake[] brakes;
        private AGPS[] gps;
        private ICamera[] cameras;
        private ALidar[] lidars;

        private AutonomousVehicleConfig autonomousVehicleConfig;

        public Builder setChassis(IChassis chassis) {
            this.chassis = chassis;
            return this;
        }

        public Builder setEngine(EngineController engine) {
            this.engine = engine;
            subscribe(engine);
            return this;
        }

        public Builder setBattery(Battery battery) {
            this.battery = battery;
            return this;
        }

        public Builder setHeadLights(AHeadLight[] headLights) {
            this.headLights = headLights;
            for (AHeadLight headLight : headLights) {
                subscribe(headLight);
            }
            return this;
        }

        public Builder setBrakeLight(ABrakeLight[] brakeLight) {
            this.brakeLight = brakeLight;
            return this;
        }

        public Builder setDoors(Door[] doors) {
            this.doors = doors;
            return this;
        }

        public Builder setSeatBenchs(SeatBench[] seatBenchs) {
            this.seatBenchs = seatBenchs;
            return this;
        }

        public Builder setWheels(IWheel[] wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder setBrakes(ABrake[] brakes) {
            this.brakes = brakes;
            for (ABrake brake : brakes) {
                subscribe(brake);
            }
            return this;
        }

        public Builder setGps(AGPS[] gps) {
            this.gps = gps;
            for (AGPS g : gps) {
                subscribe(g);
            }
            return this;
        }

        public Builder setCameras(ICamera[] cameras) {
            this.cameras = cameras;
            for (ICamera camera : cameras) {
                subscribe(camera);
            }
            return this;
        }

        public Builder setLidars(ALidar[] lidars) {
            this.lidars = lidars;
            for (ALidar lidar : lidars) {
                subscribe(lidar);
            }
            return this;
        }
        public Builder setAutonomousVehicleConfig(AutonomousVehicleConfig config){
            this.autonomousVehicleConfig = config;
            return this;
        }

        public AutonomousVehicle build() {
            ReceiverModule.INSTANCE.setCentralUnit(this.centralUnit);
            return new AutonomousVehicle(this);
        }



        private <T> void subscribe(T subscriber) {
            centralUnit.addSubscriber((Subscriber) subscriber);
        }

    }
}
