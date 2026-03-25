package model;

import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {
    private List<LibraryItem> items;

    public LibraryDatabase() {
        this.items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    public LibraryItem findItemById(String id) {
        for (LibraryItem item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public List<LibraryItem> getAllItems() {
        return new ArrayList<>(items);
    }
}
