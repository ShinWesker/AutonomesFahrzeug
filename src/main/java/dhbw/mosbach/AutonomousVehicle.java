package dhbw.mosbach;

public class AutonomousVehicle {

    private final CentralUnit centralUnit;
    public AutonomousVehicle(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void startup(){
        System.out.println("Start: ");
        centralUnit.engineOn();
        centralUnit.ledOn();
        centralUnit.gpsConnectSatellite("118.75");
        centralUnit.cameraOn();
        centralUnit.lidarOn();
        centralUnit.turnSignalLeftOn();
        System.out.println();
    }

    public void move(double deltaRPM, double seconds){
        System.out.println("Move: ");
        centralUnit.turnSignalLeftOff();
        centralUnit.turnSignalRightOff();
        centralUnit.ledDimmed();
        centralUnit.engineIncreaseRPM(deltaRPM,seconds);
        centralUnit.brakeSet(0);
        centralUnit.brakeLightsOff();
        System.out.println();
    }

    public void leftTurn(double deltaRPM, double seconds){
        System.out.println("Turn left: ");
        centralUnit.turnSignalLeftOn();
        centralUnit.engineDecreaseRPM(deltaRPM,seconds);
        centralUnit.brakeSet(70);
        centralUnit.brakeLightsOn();
        System.out.println();

    }

    public void rightTurn(double deltaRPM, double seconds){
        System.out.println("Turn right: ");
        centralUnit.turnSignalRightOn();
        centralUnit.engineDecreaseRPM(deltaRPM,seconds);
        centralUnit.brakeSet(70);
        centralUnit.brakeLightsOn();
        System.out.println();

    }

    public void stop(){
        System.out.println("Stop: ");
        centralUnit.brakeSet(100);
        centralUnit.brakeLightsOn();
        System.out.println();

    }

    public void emergencyStop(){
        System.out.println("Emergency stop: ");
        centralUnit.brakeSet(100);
        centralUnit.brakeLightsOn();
        centralUnit.turnSignalHazardWarningOn();
        centralUnit.engineOff();
        centralUnit.ledHighBeam();
        centralUnit.cameraOff();
        centralUnit.lidarOff();
        System.out.println();
    }

    public void shutdown(){
        System.out.println("Shutdown: ");
        centralUnit.brakeSet(100);
        centralUnit.engineOff();
        centralUnit.brakeLightsOff();
        centralUnit.ledOff();
        centralUnit.turnSignalHazardWarningOff();
        centralUnit.gpsOff();
        centralUnit.cameraOff();
        centralUnit.lidarOff();
        System.out.println();
    }

    // TODO Builder über Interface strucutre
}
