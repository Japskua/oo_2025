package main;

public class App {
    public static void main(String[] args) {
        // Create an array of different shapes
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(3, 4);

        // Process all shapes polymorphically
        System.out.println("Processing different shapes polymorphically:");
        System.out.println("----------------------------------------");

        for (Shape shape : shapes) {
            // The same method call works for all shapes
            shape.displayInfo();

            // This demonstrates polymorphism:
            // The correct calculateArea() method is called based on the actual object type
            System.out.println("Area: " + shape.calculateArea());
            System.out.println();
        }

        // Demonstrate the benefit of polymorphism with a method that works with any
        // shape
        System.out.println("Calculating total area of all shapes:");
        System.out.println("Total Area: " + calculateTotalArea(shapes));
    }

    // This method demonstrates how polymorphism allows for code reusability
    // It can work with any shape without knowing its specific type
    public static double calculateTotalArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}
