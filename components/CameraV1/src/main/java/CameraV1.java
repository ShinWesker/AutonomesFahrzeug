public class CameraV1 {
    public Port port;
    private final String manufacturer;
    private final String type;
    private final String id;
    private boolean isOn;

    private static final CameraV1 instance = new CameraV1();

    public static CameraV1 getInstance() {
        return instance;
    }

    private CameraV1() {
        port = new Port();
        this.manufacturer = "default";
        this.type = "default";
        this.id = "default";
        this.isOn = false;
    }

    public void innerOn() {
        isOn = true;
        System.out.println("Camera V1 on!");
    }

    public void innerOff() {
        isOn = false;
        System.out.println("Camera V1 off!");
    }

    public class Port implements ICameraV1 {
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
