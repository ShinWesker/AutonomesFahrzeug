import dhbw.mosbach.AutonomousVehicle;
import dhbw.mosbach.JsonConfig;
import dhbw.mosbach.carconfiguration.AutonomousVehicleConfig;
import dhbw.mosbach.parts.battery.Battery;
import dhbw.mosbach.parts.brake.ABrake;
import dhbw.mosbach.parts.brake.Brake;
import dhbw.mosbach.parts.brakelight.ABrakeLight;
import dhbw.mosbach.parts.brakelight.BrakeLight;
import dhbw.mosbach.parts.camera.CameraHandler;
import dhbw.mosbach.parts.camera.ICamera;
import dhbw.mosbach.parts.chassis.Chassis;
import dhbw.mosbach.parts.door.Door;
import dhbw.mosbach.parts.electricalengine.EngineConfig;
import dhbw.mosbach.parts.electricalengine.EngineController;
import dhbw.mosbach.parts.gps.AGPS;
import dhbw.mosbach.parts.gps.GPS;
import dhbw.mosbach.parts.headlight.AHeadLight;
import dhbw.mosbach.parts.headlight.HeadLight;
import dhbw.mosbach.parts.lidar.ALidar;
import dhbw.mosbach.parts.seatbench.SeatBench;
import dhbw.mosbach.parts.wheel.Wheel;

public class TestUtil {

    public static AutonomousVehicle createVehicleWithMocks(
            Chassis chassis,
            EngineController engineController,
            Battery battery,
            AHeadLight[] headLights,
            ABrakeLight[] brakeLights,
            Door[] doors,
            SeatBench[] seatBenchs,
            Wheel[] wheels,
            ABrake[] brakes,
            AGPS[] gps,
            ICamera[] cameras,
            ALidar[] lidars,
            AutonomousVehicleConfig autonomousVehicleConfig) {

        AutonomousVehicle.Builder builder = new AutonomousVehicle.Builder();

        builder.setChassis(chassis != null ? chassis : new Chassis());
        builder.setEngine(engineController != null ? engineController : new EngineController(EngineConfig.INSTANCE.getEngineType()));
        builder.setBattery(battery != null ? battery : new Battery());
        builder.setHeadLights(headLights != null ? headLights : new HeadLight[]{new HeadLight(), new HeadLight(), new HeadLight(), new HeadLight()});
        builder.setBrakeLight(brakeLights != null ? brakeLights : new BrakeLight[]{new BrakeLight(), new BrakeLight(), new BrakeLight(), new BrakeLight()});
        builder.setDoors(doors != null ? doors : new Door[]{new Door(), new Door(), new Door(), new Door()});
        builder.setSeatBenchs(seatBenchs != null ? seatBenchs : new SeatBench[]{new SeatBench(), new SeatBench()});
        builder.setWheels(wheels != null ? wheels : new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()});
        builder.setBrakes(brakes != null ? brakes : new Brake[]{new Brake(), new Brake(), new Brake(), new Brake()});
        builder.setGps(gps != null ? gps : new GPS[]{new GPS(), new GPS()});
        builder.setCameras(cameras != null ? cameras : new CameraHandler[]{new CameraHandler(), new CameraHandler(), new CameraHandler(), new CameraHandler()});
        builder.setLidars(lidars != null ? lidars : new ALidar[]{JsonConfig.INSTANCE.getLidar(), JsonConfig.INSTANCE.getLidar(), JsonConfig.INSTANCE.getLidar(), JsonConfig.INSTANCE.getLidar()});
        builder.setAutonomousVehicleConfig(autonomousVehicleConfig != null ? autonomousVehicleConfig : new AutonomousVehicleConfig());

        return builder.build();
    }
}