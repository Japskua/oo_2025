// SOLID Principles Demonstration
// Week 9

/**
 * The SOLID principles are:
 * 1. S - Single Responsibility Principle
 * 2. O - Open/Closed Principle
 * 3. L - Liskov Substitution Principle
 * 4. I - Interface Segregation Principle
 * 5. D - Dependency Inversion Principle
 */

// ==========================================
// 1. Single Responsibility Principle (SRP)
// ==========================================
// "A class should have only one reason to change"
// Each class should have a single responsibility or purpose

// Bad Example - Multiple responsibilities
class StudentBad {
    private String name;
    private String email;

    // Student data methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Database operations - doesn't belong here!
    public void saveToDatabase() {
        System.out.println("Saving student to database: " + name);
        // Database code...
    }

    // File export operations - doesn't belong here!
    public void exportToFile() {
        System.out.println("Exporting student to file: " + name);
        // File export code...
    }
}

// Good Example - Single responsibility
class Student {
    private String name;
    private String email;

    // Constructor
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Student data methods - this class only manages student data
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

// Separate class for database operations
class StudentRepository {
    public void save(Student student) {
        System.out.println("Saving student to database: " + student.getName());
        // Database code...
    }

    public Student findByEmail(String email) {
        System.out.println("Finding student by email: " + email);
        // Database lookup code...
        return null; // Placeholder
    }
}

// Separate class for file operations
class StudentFileExporter {
    public void exportToFile(Student student) {
        System.out.println("Exporting student to file: " + student.getName());
        // File export code...
    }
}

// ==========================================
// 2. Open/Closed Principle (OCP)
// ==========================================
// "Software entities should be open for extension, but closed for modification"
// You should be able to add new functionality without changing existing code

// Bad Example - Need to modify class for each new shape
class AreaCalculatorBad {
    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getHeight();
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        }
        // Need to modify this class every time we add a new shape!
        return 0;
    }
}

// Good Example - Open for extension
// Step 1: Create a common interface
interface Shape {
    double calculateArea();
}

// Step 2: Implement interface for each shape
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Step 3: Create a class that's closed for modification
class AreaCalculator {
    public double calculateArea(Shape shape) {
        // No need to modify this method when adding new shapes
        return shape.calculateArea();
    }
}

// We can add new shapes without modifying AreaCalculator
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// ==========================================
// 3. Liskov Substitution Principle (LSP)
// ==========================================
// "Objects of a superclass should be replaceable with objects of a subclass
// without affecting the correctness of the program"

// Bad Example - Violating LSP
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        // Ostriches can't fly, so this violates LSP
        throw new UnsupportedOperationException("Ostriches can't fly!");
    }
}

// Good Example - Respecting LSP
// Redesigned class hierarchy
class Animal {
    public void eat() {
        System.out.println("Eating...");
    }
}

class FlyingAnimal extends Animal {
    public void fly() {
        System.out.println("Flying...");
    }
}

class NonFlyingAnimal extends Animal {
    // No fly method
}

class Sparrow extends FlyingAnimal {
    // Inherits fly() appropriately
}

class OstrichLSP extends NonFlyingAnimal {
    // Doesn't promise to fly
}

// ==========================================
// 4. Interface Segregation Principle (ISP)
// ==========================================
// "Clients should not be forced to depend on interfaces they do not use"
// Many specific interfaces are better than one general-purpose interface

// Bad Example - Fat interface
interface WorkerBad {
    void work();

    void eat();

    void sleep();
}

// Classes must implement methods they don't need
class RobotWorkerBad implements WorkerBad {
    @Override
    public void work() {
        System.out.println("Robot working...");
    }

    @Override
    public void eat() {
        // Robots don't eat, but forced to implement
        throw new UnsupportedOperationException("Robots don't eat!");
    }

    @Override
    public void sleep() {
        // Robots don't sleep, but forced to implement
        throw new UnsupportedOperationException("Robots don't sleep!");
    }
}

// Good Example - Segregated interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

// Human implements all interfaces
class Human implements Workable, Eatable, Sleepable {
    @Override
    public void work() {
        System.out.println("Human working...");
    }

    @Override
    public void eat() {
        System.out.println("Human eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Human sleeping...");
    }
}

// Robot only implements what it needs
class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot working...");
    }
    // No need to implement eat() or sleep()
}

// ==========================================
// 5. Dependency Inversion Principle (DIP)
// ==========================================
// "High-level modules should not depend on low-level modules.
// Both should depend on abstractions."
// "Abstractions should not depend on details. Details should depend on
// abstractions."

// Bad Example - Direct dependency on implementation
class LightBulb {
    public void turnOn() {
        System.out.println("LightBulb turned on");
    }

    public void turnOff() {
        System.out.println("LightBulb turned off");
    }
}

class SwitchBad {
    private LightBulb bulb; // Direct dependency on LightBulb implementation

    public SwitchBad() {
        this.bulb = new LightBulb(); // Hard-coded dependency
    }

    public void operate() {
        // Cannot control other devices
        bulb.turnOn();
    }
}

// Good Example - Dependency on abstraction
// Step 1: Create an abstraction
interface Switchable {
    void turnOn();

    void turnOff();
}

// Step 2: Make details depend on the abstraction
class LightBulbDIP implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("LightBulb turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb turned off");
    }
}

class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Fan turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan turned off");
    }
}

// Step 3: Make high-level modules depend on the abstraction
class Switch {
    private Switchable device; // Depends on abstraction, not implementation

    // Dependency injected through constructor
    public Switch(Switchable device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }
}

// ==========================================
// Main class to demonstrate usage
// ==========================================
public class SOLIDPrinciples {
    public static void main(String[] args) {
        System.out.println("SOLID Principles Demonstration");

        // Single Responsibility Principle
        Student student = new Student("John Doe", "john@example.com");
        StudentRepository repository = new StudentRepository();
        repository.save(student);

        // Open/Closed Principle
        AreaCalculator calculator = new AreaCalculator();
        Shape rectangle = new Rectangle(5, 10);
        Shape circle = new Circle(7);
        Shape triangle = new Triangle(4, 6);

        System.out.println("Rectangle area: " + calculator.calculateArea(rectangle));
        System.out.println("Circle area: " + calculator.calculateArea(circle));
        System.out.println("Triangle area: " + calculator.calculateArea(triangle));

        // Liskov Substitution Principle
        FlyingAnimal sparrow = new Sparrow();
        sparrow.fly(); // Works as expected

        // Interface Segregation Principle
        Workable human = new Human();
        Workable robot = new Robot();
        human.work();
        robot.work();

        // Dependency Inversion Principle
        Switchable bulb = new LightBulbDIP();
        Switchable fan = new Fan();

        Switch bulbSwitch = new Switch(bulb);
        Switch fanSwitch = new Switch(fan);

        bulbSwitch.turnOn(); // Turns on light bulb
        fanSwitch.turnOn(); // Turns on fan
    }
}