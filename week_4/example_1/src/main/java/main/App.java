package main;

import java.util.List;
import java.util.Scanner;

/**
 * Entry point for the Diary application.
 */
public class App {
    public static void main(String[] args) {
        // Scanner for reading user input
        Scanner scanner = new Scanner(System.in);

        // Initialize the Diary with a file path for storing entries
        // NOTE: We could use .dat, .bin or something else
        // but for the sake of simplicity we use .ser, so we know it's serialized
        Diary diary = new Diary("diaryEntries.ser");

        while (true) {
            // Display the main menu
            System.out.println("\nDiary Application");
            System.out.println("1. Add a new entry");
            System.out.println("2. View all entries");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            // Read user choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            // Handle user choice with a switch statement
            switch (choice) {
                case 1:
                    // Prompt user for the date and content of the diary entry
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Write your diary entry: ");
                    String content = scanner.nextLine();

                    // Create a new DiaryEntry object and add it to the diary
                    DiaryEntry entry = new DiaryEntry(date, content);
                    diary.addEntry(entry);
                    System.out.println("Diary entry saved.");
                    break;

                case 2:
                    // Retrieve all diary entries from the diary
                    List<DiaryEntry> entries = diary.getEntries();

                    // Check if there are any entries and display them
                    if (entries.isEmpty()) {
                        System.out.println("No entries found.");
                    } else {
                        System.out.println("\nYour Diary Entries:");
                        for (DiaryEntry e : entries) {
                            System.out.println(e); // Calls the toString() method of DiaryEntry
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 3:
                    // Exit the application
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close(); // Close the Scanner
                    return; // End the program

                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}