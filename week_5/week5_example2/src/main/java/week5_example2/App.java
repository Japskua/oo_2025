package week5_example2;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create an engine with initial fuel
        Engine engine = new Engine(100.0);

        // Create a spaceship with the engine
        Spaceship spaceship = new Spaceship("Star Voyager", engine);

        // Create and add some cargo
        Cargo supplies = new Cargo(500.0, "Food and Water");
        Cargo equipment = new Cargo(1000.0, "Scientific Equipment");
        spaceship.addCargo(supplies);
        spaceship.addCargo(equipment);

        // Start the journey
        boolean journeyStarted = spaceship.startJourney();
        System.out.println("Journey started: " + journeyStarted);

        // Check spaceship status
        System.out.println(spaceship.getStatus());

        // Refuel the engine
        engine.refuel(50.0);
    }
}
