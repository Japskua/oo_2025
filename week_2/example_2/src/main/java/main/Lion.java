package main;

/**
 * Represents a Lion in the zoo.
 */
public class Lion {
    private String name;

    /**
     * Constructs a Lion with the given name.
     *
     * @param name the name of the lion
     */
    public Lion(String name) {
        this.name = name;
    }

    /**
     * Makes the lion shout.
     */
    public void shout() {
        System.out.println(name + " roars: 'Roaaar!'");
    }
}