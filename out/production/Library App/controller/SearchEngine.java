//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package controller;

import java.util.ArrayList;
import java.util.List;
import model.LibraryItem;

public class SearchEngine {
    public static List<LibraryItem> linearSearchByTitle(List<LibraryItem> items, String title) {
        List<LibraryItem> result = new ArrayList();

        for(LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                result.add(item);
            }
        }

        return result;
    }
}
