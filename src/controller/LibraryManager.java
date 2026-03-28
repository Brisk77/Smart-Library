package controller;

import model.LibraryDatabase;
import model.LibraryItem;
import model.UserAccount;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private LibraryDatabase database;
    private List<UserAccount> users; // In-memory user storage

    public LibraryManager() {
        this.database = new LibraryDatabase();
        this.users = new ArrayList<>();
        // Add a sample user for testing
        users.add(new UserAccount("testuser", "Test User"));
    }

    public void addItem(LibraryItem item) {
        database.addItem(item);
    }

    public void removeItem(String itemId) {
        LibraryItem item = database.findItemById(itemId);
        if (item != null) {
            database.removeItem(item);
        }
    }

    // --- Core Business Logic (Borrow/Return Role) ---

    public boolean processBorrow(String userId, String itemId) {
        UserAccount user = findUserById(userId);
        LibraryItem item = database.findItemById(itemId);

        if (user != null && item != null && item.isAvailable()) {
            item.setAvailable(false);
            user.borrowItem(item);
            return true;
        }
        return false;
    }

    public void processReturn(String userId, String itemId) {
        UserAccount user = findUserById(userId);
        LibraryItem item = database.findItemById(itemId);

        if (user != null && item != null) {
            item.setAvailable(true);
            user.returnItem(item);
        }
    }

    // --- View & Search Logic (Search Specialist Role) ---

    public List<LibraryItem> getSortedItems(String criteria) {
        List<LibraryItem> allItems = new ArrayList<>(database.getAllItems()); // Create a mutable copy
        if (criteria.equalsIgnoreCase("Title")) {
            Sorting.mergeSort(allItems, Sorting.LibraryComparators.byTitle());
        } else if (criteria.equalsIgnoreCase("Year")) {
            Sorting.mergeSort(allItems, Sorting.LibraryComparators.byYear());
        } else if (criteria.equalsIgnoreCase("Author")) {
            Sorting.mergeSort(allItems, Sorting.LibraryComparators.byAuthor());
        }
        return allItems;
    }

    // Helper to find users
    private UserAccount findUserById(String id) {
        // Correctly filter by the user ID field
        return users.stream()
                .filter(u -> u.getUserId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public LibraryDatabase getDatabase() {
        return database;
    }

    public List<UserAccount> getUsers() {
        return users;
    }
}
