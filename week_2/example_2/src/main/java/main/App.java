package main;

/**
 * The main class of the application.
 * It creates animals and makes them shout.
 */
public class App {
    public static void main(String[] args) {
        // Create all the animals
        Elephant elephant = new Elephant("Dumbo");
        Lion lion = new Lion("Simba");
        Giraffe giraffe = new Giraffe("Geoffrey");

        // Make all animals shout
        lion.shout();
        elephant.shout();
        giraffe.shout();
    }
}
