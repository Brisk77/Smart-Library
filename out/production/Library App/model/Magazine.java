//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package model;

public class Magazine extends LibraryItem {
    private int issueNumber;
    private static final int BORROW_DURATION = 7;

    public Magazine(String id, String title, String author, int year, int issueNumber) {
        super(id, title, author, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return this.issueNumber;
    }

    public String getType() {
        return "Magazine";
    }

    public int getBorrowDuration() {
        return 7;
    }
}
