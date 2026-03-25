//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package model;

public class Journal extends LibraryItem {
    private String conferenceName;
    private static final int BORROW_DURATION = 14;

    public Journal(String id, String title, String author, int year, String conferenceName) {
        super(id, title, author, year);
        this.conferenceName = conferenceName;
    }

    public String getConferenceName() {
        return this.conferenceName;
    }

    public String getType() {
        return "Journal";
    }

    public int getBorrowDuration() {
        return 14;
    }
}
