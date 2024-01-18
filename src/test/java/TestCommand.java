import dhbw.mosbach.command.ICommand;
import dhbw.mosbach.command.Key;
import dhbw.mosbach.command.StartupCommand;
import dhbw.mosbach.parts.emergencybutton.EmergencyButton;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestCommand {

    @Test
    public void testCarKey() {
        Key key = new Key();
        ICommand cmd = mock(StartupCommand.class);
        key.setCommand(cmd);
        key.execute();

        verify(cmd).execute();
    }
}
