package fi.lut.week_6.example_1;

// Lion class inheriting from Animal
public class Lion extends Animal {
    private int maneLength;

    public Lion(String name, int age, int maneLength) {
        super(name, age);
        this.maneLength = maneLength;
    }

    @Override
    public String makeSound() {
        return "Roar!";
    }

    // Lion-specific method
    public void hunt() {
        System.out.println(getName() + " is hunting prey.");
    }
}
