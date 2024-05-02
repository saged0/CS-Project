import java.util.*;
import java.io.*;

class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to search for books by title, author, or genre
    public List<Book> searchBooks(String query) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(query) || book.getAuthor().contains(query) || book.getGenre().contains(query)) {
                result.add(book);
            }
        }
        return result;
    }

        // Method to display all books
        public void displayBooks () {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
