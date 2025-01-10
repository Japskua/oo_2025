package main;

/**
 * Represents an Elephant in the zoo.
 */
public class Elephant {
    private String name;

    /**
     * Constructs an Elephant with the given name.
     *
     * @param name the name of the elephant
     */
    public Elephant(String name) {
        this.name = name;
    }

    /**
     * Makes the elephant shout.
     */
    public void shout() {
        System.out.println(name + " trumpets: 'Pawoooo!'");
    }
}