import dhbw.mosbach.events.electricalengine.EventDecreaseRPM;
import dhbw.mosbach.events.electricalengine.EventEngineOff;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.electricalengine.EventIncreaseRPM;
import dhbw.mosbach.parts.electricalengine.EngineController;
import dhbw.mosbach.parts.electricalengine.EngineX;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestBridge {

    @Test
    public void testReceiveDecreaseRPM(){
        EngineX mockedEngine = mock(EngineX.class);
        EngineController engineController = new EngineController(mockedEngine);
        engineController.receive(new EventDecreaseRPM(1,1));
        verify(mockedEngine).receive(Mockito.any(EventDecreaseRPM.class));
    }

    @Test
    public void testEngineOn(){
        EngineX mockedEngine = mock(EngineX.class);
        EngineController engineController = new EngineController(mockedEngine);
        engineController.receive(new EventEngineOn());
        verify(mockedEngine).receive(Mockito.any(EventEngineOn.class));
    }

    @Test
    public void testEngineOff(){
        EngineX mockedEngine = mock(EngineX.class);
        EngineController engineController = new EngineController(mockedEngine);
        engineController.receive(new EventEngineOff());
        verify(mockedEngine).receive(Mockito.any(EventEngineOff.class));
    }

    @Test
    public void testIncreaseRPM(){
        EngineX mockedEngine = mock(EngineX.class);
        EngineController engineController = new EngineController(mockedEngine);
        engineController.receive(new EventIncreaseRPM(1,1));
        verify(mockedEngine).receive(Mockito.any(EventIncreaseRPM.class));
    }

}
