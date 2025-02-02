package lut.fi.example.week_5.example_1;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Creating a Book object
        Book myBook = new Book("Java Programming", 400);

        // Using the public methods
        System.out.println(myBook.getBookInfo());  // Output: Book: Java Programming (400 pages)
        myBook.updatePageCount(450);               // Update page count
        System.out.println(myBook.getBookInfo());  // Output: Book: Java Programming (450 pages)

        // Accessing attributes
        System.out.println(myBook.title);          // Works because title is public
        // System.out.println(myBook.pageCount);   // Won't work because pageCount is private
    }
}
