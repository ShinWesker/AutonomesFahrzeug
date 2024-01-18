package dhbw.mosbach.carconfiguration;

import java.util.EnumSet;
import java.util.Scanner;

public class VehicleConfigCLI {

    private final AutonomousVehicleConfig vehicleConfig;

    public VehicleConfigCLI(AutonomousVehicleConfig autonomousVehicleConfig) {
        this.vehicleConfig = autonomousVehicleConfig;
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("[1] Print");
            System.out.println("[2] Set Parameter");
            System.out.println("[3] Undo");
            System.out.println("[4] Exit");

            System.out.print("Choose an option: ");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1 -> printSettings();
                case 2 -> setParameter(scanner);
                case 3 -> undoChanges();
                case 4 -> exit =true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void printSettings() {
        System.out.println("Current Settings:");
        System.out.println("1. Reject Drunken Passenger: " + vehicleConfig.isRejectDrunkenPassenger());
        System.out.println("2. Stop By Police Request: " + vehicleConfig.isStopByPoliceRequest());
        System.out.println("3. Allow Drive By Night: " + vehicleConfig.isAllowDriveByNight());
        System.out.println("4. Behavior With Nagging Passengers: " + vehicleConfig.getBehaviorWithNaggingPassengers());
        System.out.println("5. Music During Drive: " + vehicleConfig.getMusicDuringDrive());
    }

    private void setParameter(Scanner scanner) {
        printSettings();

        System.out.println("Enter the id of the parameter to change:");
        int paramId = getIntInput(scanner);

        switch (paramId) {
            case 1 -> vehicleConfig.setRejectDrunkenPassenger(getBooleanInput(scanner, "Enter new value for Reject Drunken Passenger (true/false): "));
            case 2 -> vehicleConfig.setStopByPoliceRequest(getBooleanInput(scanner, "Enter new value for Stop By Police Request (true/false): "));
            case 3 -> vehicleConfig.setAllowDriveByNight(getBooleanInput(scanner, "Enter new value for Allow Drive By Night (true/false): "));
            case 4 -> setEnumParameter(scanner, "Behavior With Nagging Passengers", BehaviorNaggingPassenger.class);
            case 5 -> setEnumParameter(scanner, "Music During Drive", MusicDuringDrive.class);
            default -> System.out.println("Invalid parameter id.");
        }
    }

    private void undoChanges() {
        vehicleConfig.restore();
        System.out.println("Last change has been undone.");
    }

    private int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private boolean getBooleanInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid input. Please enter true or false.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextBoolean();
    }

    private <E extends Enum<E>> void setEnumParameter(Scanner scanner, String paramName, Class<E> enumClass) {
        E value;
        while (true) {
            System.out.print("Enter new value for " + paramName + " (" + String.join("/", getEnumNames(enumClass)) + "): ");
            try {
                value = Enum.valueOf(enumClass, scanner.next().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid value. Please try again.");
            }
        }
        if (paramName.equals("Behavior With Nagging Passengers")) {
            vehicleConfig.setBehaviorWithNaggingPassengers((BehaviorNaggingPassenger) value);
        } else if (paramName.equals("Music During Drive")) {
            vehicleConfig.setMusicDuringDrive((MusicDuringDrive) value);
        }
    }

    private <E extends Enum<E>> String[] getEnumNames(Class<E> enumClass) {
        return EnumSet.allOf(enumClass).stream().map(Enum::name).toArray(String[]::new);
    }
}