import dhbw.mosbach.AutonomousVehicle;
import dhbw.mosbach.events.brake.EventBrakeSet;
import dhbw.mosbach.events.camera.EventCameraOn;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.headlight.EventLEDOn;
import dhbw.mosbach.parts.brake.Brake;
import dhbw.mosbach.parts.camera.CameraHandler;
import dhbw.mosbach.parts.electricalengine.EngineController;
import dhbw.mosbach.parts.headlight.AHeadLight;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class TestBuilder {

    @Test
    void testVehicleBuilder(){
        AutonomousVehicle vehicle = TestUtil.createVehicleWithMocks(null, null, null, null, null, null, null, null, null, null, null, null, null);
        assertNotNull(vehicle);
    }

    @Test
    void testVehicleBrakes() {
        Brake[] mockedBrakes = {mock(Brake.class), mock(Brake.class), mock(Brake.class), mock(Brake.class)};
        AutonomousVehicle vehicle = TestUtil.createVehicleWithMocks(null, null, null, null, null, null, null, null, mockedBrakes, null, null, null, null);

        vehicle.stop();
        for (Brake brake : mockedBrakes) {
            Mockito.verify(brake).receive(Mockito.any(EventBrakeSet.class));
        }
    }

    @Test
    void testVehicleEngine() {
        EngineController engine = mock(EngineController.class);
        AutonomousVehicle vehicle = TestUtil.createVehicleWithMocks(null, engine, null, null, null, null, null, null, null, null, null, null, null);

        vehicle.startup();
        Mockito.verify(engine).receive(Mockito.any(EventEngineOn.class));
    }

    @Test
    void testVehicleHeadlights() {
        AHeadLight[] mockedHeadLights = {mock(AHeadLight.class), mock(AHeadLight.class), mock(AHeadLight.class), mock(AHeadLight.class)};
        AutonomousVehicle vehicle = TestUtil.createVehicleWithMocks(null, null, null, mockedHeadLights, null, null, null, null, null, null, null, null, null);
        vehicle.startup();

        for (AHeadLight headLight : mockedHeadLights) {
            Mockito.verify(headLight).receive(Mockito.any(EventLEDOn.class));
        }
    }

    @Test
    void testVehicleCameras(){
        CameraHandler[] mockedCameras = {mock(CameraHandler.class), mock(CameraHandler.class), mock(CameraHandler.class), mock(CameraHandler.class)};
        AutonomousVehicle vehicle = TestUtil.createVehicleWithMocks(null, null, null, null, null, null, null, null, null, null, mockedCameras, null, null);

        vehicle.startup();

        for (CameraHandler camera : mockedCameras) {
            Mockito.verify(camera).receive(Mockito.any(EventCameraOn.class));
        }
    }
}