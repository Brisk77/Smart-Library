//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package model;

import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {
    private List<LibraryItem> items = new ArrayList();

    public void addItem(LibraryItem item) {
        this.items.add(item);
    }

    public void removeItem(LibraryItem item) {
        this.items.remove(item);
    }

    public LibraryItem findItemById(String id) {
        for(LibraryItem item : this.items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }

        return null;
    }

    public List<LibraryItem> getAllItems() {
        return new ArrayList(this.items);
    }
}
