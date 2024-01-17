package dhbw.mosbach.parts.door;

public class Door {
    private IDoorState doorState;
    private boolean isOpened;

    public Door() {
        this.doorState = new ClosedState();
        this.isOpened = false;
    }

    public void setState(IDoorState state) {
        this.doorState = state;
        this.isOpened = state instanceof OpenState;
    }

    public void signal() {
        doorState.signal(this);
    }

    public boolean isOpened() {
        return isOpened;
    }

    public String toString() {
        return "Door is " + (isOpened ? "open" : "closed");
    }
}
