package model;

public class Journal extends LibraryItem {
    private String conferenceName;
    private static final int BORROW_DURATION = 14; // 2 weeks

    public Journal(String id, String title, String author, int year, String conferenceName) {
        super(id, title, author, year);
        this.conferenceName = conferenceName;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    @Override
    public String getType() {
        return "Journal";
    }

    @Override
    public int getBorrowDuration() {
        return BORROW_DURATION;
    }
}
