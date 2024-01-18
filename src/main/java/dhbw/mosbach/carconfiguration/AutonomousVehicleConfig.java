package dhbw.mosbach.carconfiguration;

public class AutonomousVehicleConfig {

    public MementoCaretaker getMementoCaretaker() {
        return mementoCaretaker;
    }

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

    private MementoCaretaker mementoCaretaker;
    private boolean rejectDrunkenPassenger;
    private boolean stopByPoliceRequest;
    private boolean allowDriveByNight;
    private BehaviorNaggingPassenger behaviorWithNaggingPassengers;
    private MusicDuringDrive musicDuringDrive;

    public void setMementoCaretaker(MementoCaretaker mementoCaretaker) {
        save();
        this.mementoCaretaker = mementoCaretaker;
    }

    public void setRejectDrunkenPassenger(boolean rejectDrunkenPassenger) {
        save();
        this.rejectDrunkenPassenger = rejectDrunkenPassenger;
    }

    public void setStopByPoliceRequest(boolean stopByPoliceRequest) {
        save();
        this.stopByPoliceRequest = stopByPoliceRequest;
    }

    public void setAllowDriveByNight(boolean allowDriveByNight) {
        save();
        this.allowDriveByNight = allowDriveByNight;
    }

    public void setBehaviorWithNaggingPassengers(BehaviorNaggingPassenger behaviorWithNaggingPassengers) {
        save();
        this.behaviorWithNaggingPassengers = behaviorWithNaggingPassengers;
    }

    public void setMusicDuringDrive(MusicDuringDrive musicDuringDrive) {
        save();
        this.musicDuringDrive = musicDuringDrive;
    }

    public AutonomousVehicleConfig(){
        this.mementoCaretaker = new MementoCaretaker();
        this.rejectDrunkenPassenger = true;
        this.stopByPoliceRequest = true;
        this.allowDriveByNight = true;
        this.behaviorWithNaggingPassengers = BehaviorNaggingPassenger.STOP_AND_WAIT_FOR_EXCUSE;
        this.musicDuringDrive = MusicDuringDrive.AC_DC;
        save();
    }

    public void save(){
        mementoCaretaker.setMemento(new AutonomousVehicleConfigMemento(rejectDrunkenPassenger,stopByPoliceRequest,allowDriveByNight,behaviorWithNaggingPassengers,musicDuringDrive));
    }

    public void restore(){
        AutonomousVehicleConfigMemento memento = mementoCaretaker.getMemento();

        this.rejectDrunkenPassenger = memento.isRejectDrunkenPassenger();
        this.stopByPoliceRequest = memento.isStopByPoliceRequest();
        this.allowDriveByNight = memento.isAllowDriveByNight();
        this.behaviorWithNaggingPassengers = memento.getBehaviorWithNaggingPassengers();
        this.musicDuringDrive = memento.getMusicDuringDrive();
    }
}
