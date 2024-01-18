package dhbw.mosbach.command;

import dhbw.mosbach.AutonomousVehicle;
import dhbw.mosbach.ReceiverModule;

public class StartupCommand implements ICommand{
    private final Key key;

    public StartupCommand(Key key) {
        this.key = key;
    }
    @Override
    public void execute() {
        ReceiverModule.INSTANCE.activate(key.toString());
    }
}
