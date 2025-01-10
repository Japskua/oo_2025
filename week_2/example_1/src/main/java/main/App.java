package main;

// Define the RocketShip class
class RocketShip {
    // Attributes (properties)
    String name;
    int fuelLevel;
    boolean isLaunched;

    // Constructor to initialize the RocketShip
    public RocketShip(String name, int fuelLevel) {
        this.name = name;
        this.fuelLevel = fuelLevel;
        this.isLaunched = false;
    }

    // Method to launch the rocket
    public void launch() {
        if (fuelLevel > 0) {
            isLaunched = true;
            System.out.println(name + " has launched!");
        } else {
            System.out.println(name + " cannot launch due to insufficient fuel.");
        }
    }

    // Method to refuel the rocket
    public void refuel(int amount) {
        fuelLevel += amount;
        System.out.println(name + " has been refueled. Current fuel level: " + fuelLevel);
    }

    // Method to display the rocket's status
    public void displayStatus() {
        System.out.println("Rocket Name: " + name);
        System.out.println("Fuel Level: " + fuelLevel);
        System.out.println("Launch Status: " + (isLaunched ? "Launched" : "Not Launched"));
    }
}

public class App {
    public static void main(String[] args) {
        // Instantiate a RocketShip object
        RocketShip falcon9 = new RocketShip("Falcon 9", 100);

        // Display initial status
        falcon9.displayStatus();

        // Attempt to launch the rocket
        falcon9.launch();

        // Refuel the rocket
        falcon9.refuel(50);

        // Display updated status
        falcon9.displayStatus();

        // Launch the rocket again
        falcon9.launch();
    }
}
