package dhbw.mosbach;

import com.google.common.eventbus.EventBus;
import dhbw.mosbach.cryptography.IAlgorithm;
import dhbw.mosbach.cryptography.aes.AES;
import dhbw.mosbach.cryptography.aes.Configuration;
import dhbw.mosbach.events.brake.EventBrakeLightOff;
import dhbw.mosbach.events.brake.EventBrakeLightOn;
import dhbw.mosbach.events.brake.EventBrakeSet;
import dhbw.mosbach.events.camera.EventCameraOff;
import dhbw.mosbach.events.camera.EventCameraOn;
import dhbw.mosbach.events.electricalengine.EventDecreaseRPM;
import dhbw.mosbach.events.electricalengine.EventEngineOff;
import dhbw.mosbach.events.electricalengine.EventEngineOn;
import dhbw.mosbach.events.electricalengine.EventIncreaseRPM;
import dhbw.mosbach.events.gps.EventGPSConnectSatellite;
import dhbw.mosbach.events.gps.EventGPSOff;
import dhbw.mosbach.events.gps.EventGPSOn;
import dhbw.mosbach.events.headlight.EventLEDDimmed;
import dhbw.mosbach.events.headlight.EventLEDHighBeam;
import dhbw.mosbach.events.headlight.EventLEDOff;
import dhbw.mosbach.events.headlight.EventLEDOn;
import dhbw.mosbach.events.lidar.EventLidarOff;
import dhbw.mosbach.events.lidar.EventLidarOn;
import dhbw.mosbach.events.turnsignal.*;
import dhbw.mosbach.parts.battery.IBatteryTemperatureListener;
import dhbw.mosbach.parts.ultrasonicsensor.IUltraSonicListener;

import java.util.Objects;

public class CentralUnit implements IBatteryTemperatureListener, IUltraSonicListener {
    EventBus eventBus;

    private IAlgorithm crypt = new AES(Configuration.INSTANCE.salt);

    private AutonomousVehicle vehicle;

    private String key = "ZooxSDC73";

    public void activate(String key){
        if (checkPassword(key)) {
            System.out.println("Starting with Key");
            vehicle.startup();
        } else {
            System.out.println("Error wrong Key");
        }

    }

    public void deactivate(String key){
        if (checkPassword(key)) {
            System.out.println("Stopping with Key");
            vehicle.stop();
        } else {
            System.out.println("Error wrong Key");
        }

    }

    private boolean checkPassword(String key) {
        return Objects.equals(this.key, crypt.decrypt(key, Configuration.INSTANCE.secretKey));
    }

    public void setVehicle(AutonomousVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public CentralUnit() {
        this.eventBus = new EventBus();
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void brakeLightsOn() {
        eventBus.post(new EventBrakeLightOn());
    }

    public void brakeLightsOff() {
        eventBus.post(new EventBrakeLightOff());
    }

    public void brakeSet(double percentage) {
        eventBus.post(new EventBrakeSet(percentage));
    }

    public void cameraOn() {
        eventBus.post(new EventCameraOn());
    }

    public void cameraOff() {
        eventBus.post(new EventCameraOff());
    }

    public void engineOn() {
        eventBus.post(new EventEngineOn());
    }

    public void engineOff() {
        eventBus.post(new EventEngineOff());
    }

    public void engineIncreaseRPM(double deltaRPM, double seconds) {
        eventBus.post(new EventIncreaseRPM(deltaRPM, seconds));
    }

    public void engineDecreaseRPM(double deltaRPM, double seconds) {
        eventBus.post(new EventDecreaseRPM(deltaRPM, seconds));
    }

    public void ledOn() {
        eventBus.post(new EventLEDOn());
    }

    public void ledOff() {
        eventBus.post(new EventLEDOff());
    }

    public void ledDimmed() {
        eventBus.post(new EventLEDDimmed());
    }

    public void ledHighBeam() {
        eventBus.post(new EventLEDHighBeam());
    }

    public void turnSignalLeftOn() {
        eventBus.post(new EventLeftIndicatorOn());
    }

    public void turnSignalLeftOff() {
        eventBus.post(new EventLeftIndicatorOff());
    }

    public void turnSignalRightOn() {
        eventBus.post(new EventRightIndicatorOn());
    }

    public void turnSignalRightOff() {
        eventBus.post(new EventRightIndicatorOff());
    }

    public void turnSignalHazardWarningOn() {
        eventBus.post(new EventHazardWarningOn());
    }

    public void turnSignalHazardWarningOff() {
        eventBus.post(new EventHazardWarningOff());
    }

    public void gpsOn() {
        eventBus.post(new EventGPSOn());
    }

    public void gpsOff() {
        eventBus.post(new EventGPSOff());
    }

    public void gpsConnectSatellite(String frequency) {
        eventBus.post(new EventGPSConnectSatellite(frequency));
    }

    public void lidarOn() {
        eventBus.post(new EventLidarOn());
    }

    public void lidarOff() {
        eventBus.post(new EventLidarOff());
    }

    @Override
    public void reportChange() {
        System.out.println("Battery temperature has changed!");
    }

    @Override
    public void reportObstacle(int minimalDistance) {
        System.out.println("Minimal distance to obstacle: " + minimalDistance);
    }

    public EventBus getEventBus() {
        return eventBus;
    }
}
