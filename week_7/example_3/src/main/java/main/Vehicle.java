package main.java.main;

// Now, let's create an abstract class for vehicles
public abstract class Vehicle {
    // Abstract classes can have instance variables
    protected String brand;
    protected String model;
    protected int year;

    // Abstract classes can have constructors
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Abstract classes can have concrete methods with implementation
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    // Abstract methods that must be implemented by subclasses
    abstract double calculateFuelEfficiency();

    abstract void startEngine();
}