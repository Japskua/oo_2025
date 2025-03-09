package main;

/**
 * Demonstrates the Singleton pattern - a class that can only have one instance
 * This represents a student registry that manages all students in the system
 */
public class StudentRegistry {
    // The static instance variable - will hold the one and only instance
    private static StudentRegistry instance;

    // List to store students (in a real application, this would be more
    // sophisticated)
    private Student[] students;
    private int capacity;
    private int currentIndex;

    // Private constructor - prevents direct instantiation from outside the class
    private StudentRegistry(int capacity) {
        this.capacity = capacity;
        this.students = new Student[capacity];
        this.currentIndex = 0;
        System.out.println("StudentRegistry initialized with capacity: " + capacity);
    }

    // Static method to get the instance (creating it if it doesn't exist)
    public static StudentRegistry getInstance() {
        // Lazy initialization - only create when first needed
        if (instance == null) {
            instance = new StudentRegistry(100); // Default capacity of 100
        }
        return instance;
    }

    // Overloaded method to create the registry with a specific capacity
    // This can only be used if the instance hasn't been created yet
    public static StudentRegistry getInstance(int capacity) {
        if (instance == null) {
            instance = new StudentRegistry(capacity);
        } else {
            System.out.println("Warning: Registry already exists. Cannot change capacity.");
        }
        return instance;
    }

    // Instance methods for the registry
    public boolean registerStudent(Student student) {
        if (currentIndex >= capacity) {
            System.out.println("Error: Registry is full");
            return false;
        }

        // Check if student is already registered
        for (int i = 0; i < currentIndex; i++) {
            if (students[i].getId() == student.getId()) {
                System.out.println("Error: Student with ID " + student.getId() + " already exists");
                return false;
            }
        }

        students[currentIndex++] = student;
        System.out.println("Student " + student.getName() + " registered successfully");
        return true;
    }

    public void displayAllStudents() {
        System.out.println("\nStudent Registry - Registered Students:");
        if (currentIndex == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        for (int i = 0; i < currentIndex; i++) {
            Student s = students[i];
            System.out.println(s.getId() + ": " + s.getName() + " (GPA: " + s.getGpa() + ")");
        }
    }
}