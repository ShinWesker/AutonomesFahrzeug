import dhbw.mosbach.AutonomousVehicle;
import dhbw.mosbach.carconfiguration.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMemento {

    @Test
    public void testSave(){

        AutonomousVehicleConfig autonomousVehicleConfig = new AutonomousVehicleConfig();

        assertTrue(autonomousVehicleConfig.isRejectDrunkenPassenger());
        assertTrue(autonomousVehicleConfig.isStopByPoliceRequest());
        assertTrue(autonomousVehicleConfig.isAllowDriveByNight());
        assertEquals(BehaviorNaggingPassenger.STOP_AND_WAIT_FOR_EXCUSE, autonomousVehicleConfig.getBehaviorWithNaggingPassengers());
        assertEquals(MusicDuringDrive.AC_DC, autonomousVehicleConfig.getMusicDuringDrive());

        autonomousVehicleConfig.save();
        MementoCaretaker mementoCaretaker = autonomousVehicleConfig.getMementoCaretaker();
        AutonomousVehicleConfigMemento mem = mementoCaretaker.getMemento();
        assertTrue(mem.isRejectDrunkenPassenger());
        assertTrue(mem.isStopByPoliceRequest());
        assertTrue(mem.isAllowDriveByNight());
        assertEquals(BehaviorNaggingPassenger.STOP_AND_WAIT_FOR_EXCUSE, mem.getBehaviorWithNaggingPassengers());
        assertEquals(MusicDuringDrive.AC_DC, mem.getMusicDuringDrive());

    }

    @Test
    public void testRestore(){

        AutonomousVehicleConfig autonomousVehicleConfig = new AutonomousVehicleConfig();

        assertTrue(autonomousVehicleConfig.isRejectDrunkenPassenger());
        assertTrue(autonomousVehicleConfig.isStopByPoliceRequest());
        assertTrue(autonomousVehicleConfig.isAllowDriveByNight());
        assertEquals(BehaviorNaggingPassenger.STOP_AND_WAIT_FOR_EXCUSE, autonomousVehicleConfig.getBehaviorWithNaggingPassengers());
        assertEquals(MusicDuringDrive.AC_DC, autonomousVehicleConfig.getMusicDuringDrive());

        autonomousVehicleConfig.setAllowDriveByNight(false);

        assertTrue(autonomousVehicleConfig.isRejectDrunkenPassenger());
        assertTrue(autonomousVehicleConfig.isStopByPoliceRequest());
        assertFalse(autonomousVehicleConfig.isAllowDriveByNight());
        assertEquals(BehaviorNaggingPassenger.STOP_AND_WAIT_FOR_EXCUSE, autonomousVehicleConfig.getBehaviorWithNaggingPassengers());
        assertEquals(MusicDuringDrive.AC_DC, autonomousVehicleConfig.getMusicDuringDrive());

        autonomousVehicleConfig.restore();

        autonomousVehicleConfig.save();
        MementoCaretaker mementoCaretaker = autonomousVehicleConfig.getMementoCaretaker();
        AutonomousVehicleConfigMemento mem = mementoCaretaker.getMemento();
        assertTrue(mem.isRejectDrunkenPassenger());
        assertTrue(mem.isStopByPoliceRequest());
        assertTrue(mem.isAllowDriveByNight());
        assertEquals(BehaviorNaggingPassenger.STOP_AND_WAIT_FOR_EXCUSE, mem.getBehaviorWithNaggingPassengers());
        assertEquals(MusicDuringDrive.AC_DC, mem.getMusicDuringDrive());

    }


}
