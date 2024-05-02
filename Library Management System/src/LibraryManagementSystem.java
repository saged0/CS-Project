import java.util.*;
import java.io.*;

public class LibraryManagementSystem {
    private static final String BOOKS_FILE = "books.txt";
    private static final String USERS_FILE = "users.txt";

    private static void saveLibraryToFile(Library library) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(BOOKS_FILE))) {
            outputStream.writeObject(library);
            System.out.println("Library saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving library to file: " + e.getMessage());
        }
    }

    private static Library loadLibraryFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(BOOKS_FILE))) {
            return (Library) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading library from file: " + e.getMessage());
            return new Library();
        }
    }

    private static void saveUsersToFile(List<User> users) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            outputStream.writeObject(users);
            System.out.println("Users saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
        }
    }

    private static List<User> loadUsersFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            return (List<User>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading users from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Library library = loadLibraryFromFile();
        List<User> users = loadUsersFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Search for a book");
            System.out.println("2. Add a book");
            System.out.println("3. Remove a book");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Display borrowed books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter search query: ");
                    scanner.nextLine(); // Consume newline
                    String query = scanner.nextLine();
                    List<Book> searchResult = library.searchBooks(query);
                    if (searchResult.isEmpty()) {
                        System.out.println("No books found matching the query.");
                    } else {
                        System.out.println("Search results:");
                        for (Book book : searchResult) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    Book newBook = new Book(title, author, genre, true);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 3:
                    // Implement removing a book
                    System.out.print("Enter title of the book to remove: ");
                    scanner.nextLine(); // Consume newline
                    String removeTitle = scanner.nextLine();
                    List<Book> removeResult = library.searchBooks(removeTitle);
                    if (removeResult.isEmpty()) {
                        System.out.println("Book not found.");
                    } else {
                        Book bookToRemove = removeResult.get(0); // Assuming there's only one book with that title
                        library.removeBook(bookToRemove);
                        System.out.println("Book removed successfully.");
                    }
                    break;
                case 4:
                    // Implement borrowing a book
                    // Ask for user details
                    System.out.print("Enter user name: ");
                    scanner.nextLine(); // Consume newline
                    String userName = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    int userID = scanner.nextInt();
                    User user = new User(userName, userID);

                    // Ask for book details
                    System.out.print("Enter title of the book to borrow: ");
                    scanner.nextLine(); // Consume newline
                    String borrowTitle = scanner.nextLine();
                    List<Book> borrowResult = library.searchBooks(borrowTitle);
                    if (borrowResult.isEmpty()) {
                        System.out.println("Book not found.");
                    } else {
                        Book bookToBorrow = borrowResult.get(0); // Assuming there's only one book with that title
                        user.borrowBook(bookToBorrow);
                    }
                    break;
                case 5:
                    // Implement returning a book
                    // Ask for user details
                    System.out.print("Enter user name: ");
                    scanner.nextLine(); // Consume newline
                    String returnUserName = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    int returnUserID = scanner.nextInt();
                    User returnUser = new User(returnUserName, returnUserID);

                    // Ask for book details
                    System.out.print("Enter title of the book to return: ");
                    scanner.nextLine(); // Consume newline
                    String returnTitle = scanner.nextLine();
                    List<Book> returnResult = library.searchBooks(returnTitle);
                    if (returnResult.isEmpty()) {
                        System.out.println("Book not found.");
                    } else {
                        Book bookToReturn = returnResult.get(0); // Assuming there's only one book with that title
                        returnUser.returnBook(bookToReturn);
                    }
                    break;
                case 6:
                    // Implement displaying borrowed books
                    // Ask for user details
                    System.out.print("Enter user name: ");
                    scanner.nextLine(); // Consume newline
                    String displayUserName = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    int displayUserID = scanner.nextInt();
                    User displayUser = new User(displayUserName, displayUserID);
                    displayUser.displayBorrowedBooks();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();

        saveLibraryToFile(library);
        saveUsersToFile(users);
    }
}