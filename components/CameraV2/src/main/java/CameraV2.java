public class CameraV2 {
    public Port port;
    private final String manufacturer;
    private final String type;
    private final String id;
    private boolean isOn;

    private static final CameraV2 instance = new CameraV2();

    public static CameraV2 getInstance() {
        return instance;
    }

    private CameraV2() {
        port = new Port();
        this.manufacturer = "default";
        this.type = "default";
        this.id = "default";
        this.isOn = false;
    }

    public void innerOn() {
        isOn = true;
        System.out.println("Camera V2 on!");
    }

    public void innerOff() {
        isOn = false;
        System.out.println("Camera V2 off!");
    }

    public class Port implements ICameraV2 {
        @Override
        public void on() {
            innerOn();
        }

        @Override
        public void off() {
            innerOff();
        }
    }

}
