package dhbw.mosbach.parts.door;

public class OpenState implements IDoorState {
    @Override
    public void signal(Door door) {
        System.out.println("Closing the door!");
        door.setState(new OpenState());
    }

    public String toString(){
        return "open";
    }
}
