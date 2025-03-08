/**
 * This class demonstrates the use of static methods and static data members
 */
public class Student {
    // Instance variables (unique to each Student object)
    private String name;
    private int id;
    private double gpa;

    // Static variable (shared among ALL Student objects)
    private static int totalStudents = 0;
    private static double totalGpaPoints = 0.0;

    // Constructor
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;

        // Increment the static counter whenever a new Student is created
        totalStudents++;
        totalGpaPoints += gpa;
    }

    // Instance methods (operate on instance variables)
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public void updateGpa(double newGpa) {
        // Update the total GPA points by removing the old value and adding the new one
        totalGpaPoints = totalGpaPoints - this.gpa + newGpa;
        this.gpa = newGpa;
    }

    // Static methods (operate on static variables or perform utility functions)
    public static int getTotalStudents() {
        return totalStudents;
    }

    public static double getAverageGpa() {
        if (totalStudents == 0) {
            return 0.0;
        }
        return totalGpaPoints / totalStudents;
    }

    // Static utility method (doesn't depend on any instance state)
    public static String getGpaClassification(double gpa) {
        if (gpa >= 3.5)
            return "Excellent";
        if (gpa >= 3.0)
            return "Very Good";
        if (gpa >= 2.5)
            return "Good";
        if (gpa >= 2.0)
            return "Satisfactory";
        return "Needs Improvement";
    }
}

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

/**
 * A demo class to show how static members, methods and the Singleton pattern
 * are used
 */
public class StudentDemo {
    public static void main(String[] args) {
        System.out.println("Starting the Student Management System");
        System.out.println("Initial number of students: " + Student.getTotalStudents());
        System.out.println("Initial average GPA: " + Student.getAverageGpa());

        // Create some student objects
        Student alice = new Student("Alice", 1001, 3.8);
        Student bob = new Student("Bob", 1002, 3.2);
        Student charlie = new Student("Charlie", 1003, 2.9);

        // Access static data through the class
        System.out.println("\nAfter adding students:");
        System.out.println("Total number of students: " + Student.getTotalStudents());
        System.out.println("Average GPA of all students: " + Student.getAverageGpa());

        // Use the static utility method
        System.out.println("\nGPA Classifications:");
        System.out.println(alice.getName() + ": " + Student.getGpaClassification(alice.getGpa()));
        System.out.println(bob.getName() + ": " + Student.getGpaClassification(bob.getGpa()));
        System.out.println(charlie.getName() + ": " + Student.getGpaClassification(charlie.getGpa()));

        // Update a student's GPA and see the effect on static data
        System.out.println("\nUpdating Charlie's GPA from 2.9 to 3.5");
        charlie.updateGpa(3.5);

        // See the updated average
        System.out.println("New average GPA: " + Student.getAverageGpa());

        // Important clarification about how to access static members
        System.out.println("\nImportant Notes about Static Access:");
        System.out.println("Correct way to access static members: Student.getTotalStudents()");
        System.out.println("Also works but NOT recommended: alice.getTotalStudents()");

        // Demonstrate the Singleton pattern with StudentRegistry
        System.out.println("\n========== SINGLETON PATTERN DEMONSTRATION ==========");

        // Try to get the registry with different capacities
        StudentRegistry registry1 = StudentRegistry.getInstance(50);

        // This should display a warning, as we already have an instance
        StudentRegistry registry2 = StudentRegistry.getInstance(200);

        // Verify both references point to the same object
        System.out.println("\nSingleton verification:");
        System.out.println("Are registry1 and registry2 the same instance? " + (registry1 == registry2));

        // Register students in the registry
        registry1.registerStudent(alice);
        registry1.registerStudent(bob);
        registry1.registerStudent(charlie);

        // Display all students - should show the same data through registry2
        registry2.displayAllStudents();

        // Try to register a duplicate student
        Student bobClone = new Student("Bob Clone", 1002, 3.5);
        registry1.registerStudent(bobClone);

        // Get an instance without specifying capacity - should be the same instance
        StudentRegistry registry3 = StudentRegistry.getInstance();
        System.out.println("\nAre registry1 and registry3 the same instance? " + (registry1 == registry3));
    }
}