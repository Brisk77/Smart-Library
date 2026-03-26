package controller;

import model.*;
import java.util.*;

public class LibraryManager {
    private LibraryDatabase database;
    private List<UserAccount> users;
    // We reuse your existing Search & Sorting Specialist logic here
    private LibrarySearchAndSort searchSortTool;

    public LibraryManager(LibraryDatabase database) {
        this.database = database;
        this.users = new ArrayList<>();
        this.searchSortTool = new LibrarySearchAndSort();
    }

    // --- Core Business Logic (Borrow/Return Role) ---

    public boolean processBorrow(String userId, String itemId) {
        UserAccount user = findUserById(userId);
        LibraryItem item = database.findItemById(itemId);

        if (user != null && item != null && item.isAvailable()) {
            // Using your LibraryItem's internal 'isAvailable' field
            // You should add a setAvailable(boolean) method to LibraryItem if not present
            item.setAvailable(false); 
            user.borrowItem(item); // Calling your UserAccount method from Image 7
            return true;
        }
        return false;
    }

    public void processReturn(String userId, String itemId) {
        UserAccount user = findUserById(userId);
        LibraryItem item = database.findItemById(itemId);

        if (user != null && item != null) {
            item.setAvailable(true);
            user.returnItem(item); // Calling your UserAccount method from Image 7
        }
    }

    // --- View & Search Logic (Search Specialist Role) ---

    public List<LibraryItem> getSortedItems(String criteria) {
        List<LibraryItem> allItems = database.getAllItems();
        if (criteria.equalsIgnoreCase("Title")) {
            searchSortTool.mergeSort(allItems, LibraryComparators.byTitle());
        } else if (criteria.equalsIgnoreCase("Year")) {
            searchSortTool.mergeSort(allItems, LibraryComparators.byYear());
        }
        return allItems;
    }

    // Helper to find users (Since your Database only stores Items)
    private UserAccount findUserById(String id) {
        // Implementation to find user from the 'users' list
        return users.stream().filter(u -> u.getName().equals(id)).findFirst().orElse(null);
    }
}
