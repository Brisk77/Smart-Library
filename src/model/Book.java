package model;

public class Book extends LibraryItem {
    private String isbn;
    private static final int BORROW_DURATION = 21; // 3 weeks

    public Book(String id, String title, String author, int year, String isbn) {
        super(id, title, author, year);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getType() {
        return "Book";
    }

    @Override
    public int getBorrowDuration() {
        return BORROW_DURATION;
    }
}
