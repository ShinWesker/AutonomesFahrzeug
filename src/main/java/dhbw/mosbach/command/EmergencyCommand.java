package dhbw.mosbach.command;

import dhbw.mosbach.ServiceCenter;

public class EmergencyCommand implements ICommand{

    @Override
    public void execute() {
        ServiceCenter.INSTANCE.reportEmergency();
    }
}
