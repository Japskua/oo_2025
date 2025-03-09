package main;

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
