//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package model;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private final String name;
    private final List<LibraryItem> borrowedItems;

    public UserAccount(String userId, String name) {
        this.name = name;
        this.borrowedItems = new ArrayList();
    }

    public String getName() {
        return this.name;
    }

    public void borrowItem(LibraryItem item) {
        this.borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        this.borrowedItems.remove(item);
    }
}
