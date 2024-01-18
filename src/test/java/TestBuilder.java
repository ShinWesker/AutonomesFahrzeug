import dhbw.mosbach.AutonomousVehicle;
import dhbw.mosbach.events.brake.EventBrakeSet;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.parts.brake.Brake;
import dhbw.mosbach.parts.electricalengine.EngineController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class TestBuilder {

    @Test
    public void testVehicleBraking() {
        Brake[] mockedBrakes = {mock(Brake.class), mock(Brake.class), mock(Brake.class), mock(Brake.class)};
        AutonomousVehicle vehicle = TestUtil.createVehicleWithMocks(null, null, null, null, null, null, null, null, mockedBrakes, null, null, null);

        vehicle.stop();

        for (Brake brake : mockedBrakes) {
            Mockito.verify(brake).receive(Mockito.any(EventBrakeSet.class));
        }
    }

    @Test
    public void testVehicleEngine() {
        EngineController engine = mock(EngineController.class);
        AutonomousVehicle vehicle = TestUtil.createVehicleWithMocks(null, engine, null, null, null, null, null, null, null, null, null, null);

        vehicle.startup();

        Mockito.verify(engine).receive(Mockito.any(EventEngineOn.class));

    }


}
