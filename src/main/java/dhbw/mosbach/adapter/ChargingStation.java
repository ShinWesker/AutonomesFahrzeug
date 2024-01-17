package dhbw.mosbach.adapter;

public class ChargingStation {
    IConnectorPlug plug;

    public void connect(IConnectorPlug plug) {
        this.plug = plug;
    }
}
