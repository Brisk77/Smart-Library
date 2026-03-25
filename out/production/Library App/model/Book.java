//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package model;

public class Book extends LibraryItem {
    private String isbn;
    private static final int BORROW_DURATION = 21;

    public Book(String id, String title, String author, int year, String isbn) {
        super(id, title, author, year);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getType() {
        return "Book";
    }

    public int getBorrowDuration() {
        return 21;
    }
}
