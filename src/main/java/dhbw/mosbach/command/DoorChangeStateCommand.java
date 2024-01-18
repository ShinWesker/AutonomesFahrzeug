package dhbw.mosbach.command;

import dhbw.mosbach.parts.door.Door;

public class DoorChangeStateCommand implements ICommand{

    private Door door;

    public DoorChangeStateCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.signal();
    }
}
