import java.util.*;
import java.io.*;

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchBooks(String query) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(query) || book.getAuthor().contains(query) || book.getGenre().contains(query)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
