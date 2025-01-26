package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// The Diary class handles writing and reading diary entries using serialization
public class Diary {
    // List to store all diary entries in memory
    private List<DiaryEntry> entries;

    // Path to the file where diary entries are stored
    private String filePath;

    // Constructor initializes the diary and loads existing entries from the file
    public Diary(String filePath) {
        this.filePath = filePath;
        this.entries = loadEntries();
    }

    // Adds a new diary entry to the list and saves it to the file
    public void addEntry(DiaryEntry entry) {
        entries.add(entry); // Add the entry to the in-memory list
        saveEntries();      // Persist the updated list to the file
    }

    // Retrieves all diary entries currently stored in memory
    public List<DiaryEntry> getEntries() {
        return entries;
    }

    // Saves all diary entries to a file using serialization
    private void saveEntries() {
        try {
            // Create file output and object output streams
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            // Write the entire list of entries to the file
            objectOutputStream.writeObject(entries);

            // Close the streams
            objectOutputStream.close();
        } catch (IOException e) {
            // Handle errors that occur during saving
            System.out.println("Error saving entries: " + e.getMessage());
        }
    }

    // Loads all diary entries from a file using deserialization
    private List<DiaryEntry> loadEntries() {
        // Check if the file exists; if not, return an empty list
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        List<DiaryEntry> loadedEntries = null;
        try {
            // Create file input and object input streams
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            // Read the list of entries from the file
            loadedEntries = (List<DiaryEntry>) objectInputStream.readObject();

            // Close the streams
            objectInputStream.close();
        } catch (Exception e) {
            // Handle errors that occur during loading
            System.out.println("Error loading entries: " + e.getMessage());
            return new ArrayList<>(); // Return an empty list if an error occurs
        }

        // Return the loaded entries
        return loadedEntries;
    }
}
