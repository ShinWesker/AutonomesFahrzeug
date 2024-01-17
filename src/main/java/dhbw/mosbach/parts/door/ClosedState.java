package dhbw.mosbach.parts.door;

public class ClosedState implements IDoorState {
    @Override
    public void signal(Door door) {
        System.out.println("Opening the door!");
        door.setState(new OpenState());
    }

    public String toString(){
        return "closed";
    }
}
