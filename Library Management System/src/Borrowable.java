interface Borrowable {
    void borrowBook(Book book) throws BookNotAvailableException;
    void returnBook(Book book);
}