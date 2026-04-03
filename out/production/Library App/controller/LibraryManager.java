//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package controller;

import controller.Sorting.LibraryComparators;
import java.util.ArrayList;
import java.util.List;
import model.LibraryDatabase;
import model.LibraryItem;
import model.UserAccount;

public class LibraryManager {
    private LibraryDatabase database = new LibraryDatabase();
    private List<UserAccount> users = new ArrayList();

    public LibraryManager() {
        this.users.add(new UserAccount("testuser", "Test User"));
    }

    public void addItem(LibraryItem item) {
        this.database.addItem(item);
    }

    public void removeItem(String itemId) {
        LibraryItem item = this.database.findItemById(itemId);
        if (item != null) {
            this.database.removeItem(item);
        }

    }

    public boolean processBorrow(String userId, String itemId) {
        UserAccount user = this.findUserById(userId);
        LibraryItem item = this.database.findItemById(itemId);
        if (user != null && item != null && item.isAvailable()) {
            item.setAvailable(false);
            user.borrowItem(item);
            return true;
        } else {
            return false;
        }
    }

    public void processReturn(String userId, String itemId) {
        UserAccount user = this.findUserById(userId);
        LibraryItem item = this.database.findItemById(itemId);
        if (user != null && item != null) {
            item.setAvailable(true);
            user.returnItem(item);
        }

    }

    public List<LibraryItem> getSortedItems(String criteria) {
        List<LibraryItem> allItems = new ArrayList(this.database.getAllItems());
        if (criteria.equalsIgnoreCase("Title")) {
            Sorting.mergeSort(allItems, LibraryComparators.byTitle());
        } else if (criteria.equalsIgnoreCase("Year")) {
            Sorting.mergeSort(allItems, LibraryComparators.byYear());
        } else if (criteria.equalsIgnoreCase("Author")) {
            Sorting.mergeSort(allItems, LibraryComparators.byAuthor());
        }

        return allItems;
    }

    private UserAccount findUserById(String id) {
        return (UserAccount)this.users.stream().filter((u) -> u.getUserId().equals(id)).findFirst().orElse((Object)null);
    }

    public LibraryDatabase getDatabase() {
        return this.database;
    }

    public List<UserAccount> getUsers() {
        return this.users;
    }
}
