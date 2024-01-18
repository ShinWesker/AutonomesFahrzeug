package dhbw.mosbach.parts.emergencybutton;

import dhbw.mosbach.command.EmergencyCommand;
import dhbw.mosbach.command.ICommand;

public class EmergencyButton {
    private final ICommand command;

    public EmergencyButton() {
        this.command = new EmergencyCommand();
    }

    public void press(){
        command.execute();
    }

}
