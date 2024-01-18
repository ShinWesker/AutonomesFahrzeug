
import dhbw.mosbach.CentralUnit;
import dhbw.mosbach.events.camera.EventCameraOn;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestEvent {
    private CentralUnit centralUnit;
    private EventCatcher eventCatcher;
    @BeforeEach
    public void setUp() {
        centralUnit = new CentralUnit();
        eventCatcher = new EventCatcher();
        centralUnit.getEventBus().register(eventCatcher);
    }
    @Test
    public void testEngineOnEventPosted() {
        centralUnit.engineOn();
        assertTrue(eventCatcher.caughtEvents.stream().anyMatch(event -> event instanceof EventEngineOn));
    }

    @Test
    public void testCameraOnEventPosted() {
        centralUnit.cameraOn();
        assertTrue(eventCatcher.caughtEvents.stream().anyMatch(event -> event instanceof EventCameraOn));
    }
}
