package dhbw.mosbach.parts.electricalengine;

public enum EngineConfig {

    INSTANCE;

    private final EngineType engineType = EngineType.EngineX;

    public AEngine getEngineType() {
        if (engineType == EngineType.EngineNG) return new EngineNG();
        if (engineType == EngineType.EngineX) return  new EngineX();
        return null;
    }
}
