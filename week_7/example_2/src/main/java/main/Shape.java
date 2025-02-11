package main.java.main;

// Abstract base class
public abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // Abstract method that subclasses must implement
    public abstract double calculateArea();

    // Common method for all shapes
    public void displayInfo() {
        System.out.println("This is a " + name + " with area: " + calculateArea());
    }
}