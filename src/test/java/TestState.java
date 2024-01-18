import dhbw.mosbach.parts.door.Door;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestState {
    @Test
    public void testDoorStateOpen() {
        Door door = new Door();
        door.signal();
        assertTrue(door.isOpened());
    }

    @Test
    public void testDoorStateClosed() {
        Door door = new Door();
        door.signal();
        door.signal();
        System.out.println(door);
        assertFalse(door.isOpened());
    }
}
