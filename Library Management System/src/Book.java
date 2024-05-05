import java.util.*;
import java.io.*;

class Book {
    private String title;
    private String author;
    private String genre;
    private boolean available;

    public Book(String title, String author, String genre, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Available: " + available;

    }
}