package model;

public class Magazine extends LibraryItem {
    private int issueNumber;
    private static final int BORROW_DURATION = 7; // 1 week

    public Magazine(String id, String title, String author, int year, int issueNumber) {
        super(id, title, author, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    @Override
    public int getBorrowDuration() {
        return BORROW_DURATION;
    }
}
