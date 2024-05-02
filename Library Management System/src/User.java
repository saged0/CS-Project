import java.util.*;
import java.io.*;

class User implements Serializable {
    private String name;
    private int ID;
    private List<Book> borrowedBooks;

    // Constructor
    public User(String name, int ID) {
        this.name = name;
        this.ID = ID;
        borrowedBooks = new ArrayList<>();
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            borrowedBooks.add(book);
            System.out.println("Book \"" + book.getTitle() + "\" has been borrowed successfully.");
        } else {
            System.out.println("Sorry, the book is not available for borrowing.");
        }
    }

    // Method to return a book
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println("Book \"" + book.getTitle() + "\" has been returned successfully.");
        } else {
            System.out.println("You have not borrowed this book.");
        }
    }

    // Method to display borrowed books
    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            System.out.println("Books borrowed by " + name + ":");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }
}
