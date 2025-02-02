package main.java.lut.fi.example.week_5;

public class Book {
    // Attributes
    public String title;        // Public attribute
    private int pageCount;      // Private attribute
    
    // Constructor
    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }
    
    // Methods
    public String getBookInfo() {
        return "Book: " + title + " (" + pageCount + " pages)";
    }
    
    public void updatePageCount(int newCount) {
        this.pageCount = newCount;
    }
}
