package dhbw.mosbach.parts.door;

public class OpenState implements IDoorState {
    @Override
    public void signal(Door door) {
        System.out.println("Closing the door!");
        door.setState(new ClosedState());
    }

    public String toString(){
        return "open";
    }
}
