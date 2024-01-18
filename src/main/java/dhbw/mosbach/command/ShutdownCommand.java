package dhbw.mosbach.command;

import dhbw.mosbach.AutonomousVehicle;
import dhbw.mosbach.ReceiverModule;

public class ShutdownCommand implements ICommand{

    private final Key key;

    public ShutdownCommand(Key key) {
        this.key = key;
    }

    @Override
    public void execute() {
        ReceiverModule.INSTANCE.deactivate(key.toString());
    }
}
