package dhbw.mosbach.carconfiguration;

public class MementoCaretaker {
    private AutonomousVehicleConfigMemento memento;

    public void setMemento(AutonomousVehicleConfigMemento memento) {
        this.memento = memento;
    }

    public AutonomousVehicleConfigMemento getMemento() {
        return memento;
    }
}
