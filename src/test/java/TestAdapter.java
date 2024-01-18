import dhbw.mosbach.adapter.ChargingStation;
import dhbw.mosbach.adapter.FourPolAdapter;
import dhbw.mosbach.adapter.IConnectorPlug;
import dhbw.mosbach.adapter.TwoPolConnector;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TestAdapter {


    @Test
    public void testAdapter(){
        FourPolAdapter fourPolAdapterMock = mock(FourPolAdapter.class);
        fourPolAdapterMock.plugIn();

        verify((TwoPolConnector) fourPolAdapterMock, times(1)).plugIn();
    }


}
