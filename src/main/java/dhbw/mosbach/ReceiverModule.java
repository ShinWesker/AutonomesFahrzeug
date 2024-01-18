package dhbw.mosbach;

public enum ReceiverModule {
    INSTANCE;

    private CentralUnit centralUnit;

    public void setCentralUnit(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void activate(String key) {

        centralUnit.activate(key);
    }

    public void deactivate(String key) {
        centralUnit.deactivate(key);
    }
}
