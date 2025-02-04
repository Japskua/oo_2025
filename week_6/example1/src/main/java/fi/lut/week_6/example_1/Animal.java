package fi.lut.week_6.example_1;

// Base class representing generic animal
public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract method that subclasses must implement
    public abstract String makeSound();

    // Common method for all animals
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
