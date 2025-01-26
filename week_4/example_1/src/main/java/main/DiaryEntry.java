package main;

import java.io.Serializable;

/**
 * The DiaryEntry class represents a single diary entry.
 * Each entry has a date and content and is serializable for persistence.
 */
public class DiaryEntry implements Serializable {

    /**
     * Serial version UID for ensuring compatibility during deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The date of the diary entry in the format "YYYY-MM-DD".
     */
    private String date;

    /**
     * The content of the diary entry.
     */
    private String content;

    /**
     * Constructs a new DiaryEntry with the specified date and content.
     *
     * @param date    The date of the entry in "YYYY-MM-DD" format.
     * @param content The content of the diary entry.
     */
    public DiaryEntry(String date, String content) {
        this.date = date;
        this.content = content;
    }

    /**
     * Gets the date of the diary entry.
     *
     * @return The date of the entry.
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the content of the diary entry.
     *
     * @return The content of the entry.
     */
    public String getContent() {
        return content;
    }

    /**
     * Returns a string representation of the diary entry.
     *
     * @return A string in the format "Date: [date]\nContent: [content]".
     */
    @Override
    public String toString() {
        return "Date: " + date + "\nContent: " + content;
    }
}
