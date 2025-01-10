package main;

/**
 * Represents a Giraffe in the zoo.
 */
public class Giraffe {
    private String name;

    /**
     * Constructs a Giraffe with the given name.
     *
     * @param name the name of the giraffe
     */
    public Giraffe(String name) {
        this.name = name;
    }

    /**
     * Makes the giraffe shout.
     */
    public void shout() {
        System.out.println(name + " hums: 'Hmmm!'");
    }
}