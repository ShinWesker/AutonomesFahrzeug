package dhbw.mosbach;

public class AutonomousVehicle {

    private final CentralUnit centralUnit;
    public AutonomousVehicle(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void startup(){
        centralUnit.engineOn();
        centralUnit.brakeLightsOn();
        centralUnit.brakeLightsOff();
        centralUnit.brakeSet(200);
    }

    public void stop(){

    }

    public void shutdown(){

    }

    public void move(double deltaRPM, double seconds){

    }

    public void leftTurn(double deltaRPM, double seconds){

    }

    public void rightTurn(double deltaRPM, double seconds){

    }

    public void emergencyStop(){

    }

    // TODO Builder über Interface strucutre
}
