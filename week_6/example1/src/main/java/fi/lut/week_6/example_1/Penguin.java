package fi.lut.week_6.example_1;

// Penguin class inheriting from Animal
public class Penguin extends Animal {
    private double swimmingSpeed;

    public Penguin(String name, int age, double swimmingSpeed) {
        super(name, age);
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public String makeSound() {
        return "Squawk!";
    }

    // Penguin-specific method
    public void swim() {
        System.out.println(getName() + " is swimming at " + swimmingSpeed + " km/h.");
    }
}
