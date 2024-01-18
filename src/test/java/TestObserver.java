import dhbw.mosbach.AutonomousVehicle;
import dhbw.mosbach.CentralUnit;
import dhbw.mosbach.parts.battery.Battery;
import dhbw.mosbach.parts.door.Door;
import dhbw.mosbach.parts.ultrasonicsensor.UltraSonicSensor;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

public class TestObserver {

    @Test
    public void testOpenDoorSensor() {
        Door[] doors = {mock(Door.class), mock(Door.class), mock(Door.class), mock(Door.class)};
        AutonomousVehicle vehicle = TestUtil.createVehicleWithMocks(null,null,null,null,null,doors,null,null,null,null,null,null, null);

        vehicle.getLeftDoorSensor().action();
        vehicle.getRightDoorSensor().action();

        for (Door door : doors) {
            verify(door).signal();
        }

    }

    @Test
    public void testCloseDoorSensor() {
        Door[] doors = {mock(Door.class), mock(Door.class), mock(Door.class), mock(Door.class)};
        AutonomousVehicle vehicle = TestUtil.createVehicleWithMocks(null,null,null,null,null,doors,null,null,null,null,null,null, null);

        vehicle.getLeftDoorSensor().action();
        vehicle.getRightDoorSensor().action();

        vehicle.getLeftDoorSensor().action();
        vehicle.getRightDoorSensor().action();
        for (Door door : doors) {
            verify(door, times(2)).signal();
        }

    }

    @Test
    public void testBatteryTemperaturChange() {
        CentralUnit centralUnit = mock(CentralUnit.class);
        Battery battery = new Battery();
        battery.getBatteryTemperatureSensor().addListener(centralUnit);
        battery.charge();
        verify(centralUnit, times(500)).reportChange();
    }


    @Test
    public void testUltraSonicSensors() {
        CentralUnit centralUnit = mock(CentralUnit.class);
        UltraSonicSensor ultraSonicSensor = new UltraSonicSensor(1);
        ultraSonicSensor.addListener(centralUnit);
        ultraSonicSensor.action(10);

       verify(centralUnit).reportObstacle(10);
    }

}
