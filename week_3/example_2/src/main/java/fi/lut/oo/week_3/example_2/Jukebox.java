package fi.lut.oo.week_3.example_2;

import java.util.ArrayList;
import java.util.HashMap;

public class Jukebox {
    public static void main(String[] args) {
        // Static Array Example
        System.out.println("=== Static Array Example ===");

        // A static array to store the names of songs
        // Static arrays have a fixed size, so we can only store a predefined number of songs.
        String[] staticJukebox = new String[3]; // Array of size 3
        staticJukebox[0] = "Drunken Sailor";
        staticJukebox[1] = "Leave Her, Johnny";
        staticJukebox[2] = "Wellerman";

        // Printing the contents of the static array
        System.out.println("Static Jukebox contents:");
        for (String song : staticJukebox) {
            System.out.println("- " + song);
        }

        // Trying to add a new song will cause an error because the array is full
        System.out.println("\nAttempting to add a new song to static array...");
        try {
            staticJukebox[3] = "Blow the Man Down"; // This line will throw an exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Cannot add more songs. Array is full!");
        }

        // ArrayList Example
        System.out.println("\n=== Dynamic ArrayList Example ===");

        // ArrayList can grow dynamically as needed, making it more suitable for scenarios
        // where the number of items is unknown or changes over time.
        ArrayList<String> dynamicJukebox = new ArrayList<>();
        dynamicJukebox.add("Drunken Sailor");
        dynamicJukebox.add("Leave Her, Johnny");
        dynamicJukebox.add("Wellerman");

        // Printing the contents of the ArrayList
        System.out.println("Dynamic Jukebox contents:");
        for (String song : dynamicJukebox) {
            System.out.println("- " + song);
        }

        // Adding a new song dynamically to the ArrayList
        System.out.println("\nAdding a new song to the ArrayList...");
        dynamicJukebox.add("Blow the Man Down");
        System.out.println("Updated Dynamic Jukebox contents:");
        for (String song : dynamicJukebox) {
            System.out.println("- " + song);
        }

        // HashMap Example
        System.out.println("\n=== HashMap Example ===");

        // A HashMap stores key-value pairs, making it ideal for associating track numbers
        // (or other identifiers) with songs. Keys are unique, but values can repeat.
        HashMap<String, String> hashMapJukebox = new HashMap<>();
        hashMapJukebox.put("1", "Drunken Sailor"); // Adding track 1
        hashMapJukebox.put("2", "Leave Her, Johnny"); // Adding track 2
        hashMapJukebox.put("3", "Wellerman"); // Adding track 3

        // Printing the contents of the HashMap
        System.out.println("HashMap Jukebox contents:");
        for (String key : hashMapJukebox.keySet()) {
            // Retrieve and print the song corresponding to each key (track number)
            System.out.println("Track " + key + ": " + hashMapJukebox.get(key));
        }

        // Retrieving a specific song by its track number (key)
        System.out.println("\nPlaying a specific song by track number (3):");
        System.out.println("Now playing: " + hashMapJukebox.get("3"));

        // Adding a new track dynamically to the HashMap
        System.out.println("\nAdding a new song to the HashMap...");
        hashMapJukebox.put("4", "Blow the Man Down"); // Adding track 4
        System.out.println("Updated HashMap Jukebox contents:");
        for (String key : hashMapJukebox.keySet()) {
            System.out.println("Track " + key + ": " + hashMapJukebox.get(key));
        }
    }
}
