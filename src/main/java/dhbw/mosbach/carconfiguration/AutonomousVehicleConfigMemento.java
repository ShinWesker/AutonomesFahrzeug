package dhbw.mosbach.carconfiguration;

public class AutonomousVehicleConfigMemento {
    private boolean rejectDrunkenPassenger;
    private boolean stopByPoliceRequest;
    private boolean allowDriveByNight;
    private BehaviorNaggingPassenger behaviorWithNaggingPassengers;
    private MusicDuringDrive musicDuringDrive;

    public boolean isRejectDrunkenPassenger() {
        return rejectDrunkenPassenger;
    }

    public boolean isStopByPoliceRequest() {
        return stopByPoliceRequest;
    }

    public boolean isAllowDriveByNight() {
        return allowDriveByNight;
    }

    public BehaviorNaggingPassenger getBehaviorWithNaggingPassengers() {
        return behaviorWithNaggingPassengers;
    }

    public MusicDuringDrive getMusicDuringDrive() {
        return musicDuringDrive;
    }

    public AutonomousVehicleConfigMemento(boolean rejectDrunkenPassenger, boolean stopByPoliceRequest, boolean allowDriveByNight, BehaviorNaggingPassenger behaviorWithNaggingPassengers, MusicDuringDrive musicDuringDrive) {
        this.rejectDrunkenPassenger = rejectDrunkenPassenger;
        this.stopByPoliceRequest = stopByPoliceRequest;
        this.allowDriveByNight = allowDriveByNight;
        this.behaviorWithNaggingPassengers = behaviorWithNaggingPassengers;
        this.musicDuringDrive = musicDuringDrive;
    }
}
