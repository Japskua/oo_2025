package main;

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