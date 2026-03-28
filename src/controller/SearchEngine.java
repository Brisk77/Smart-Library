package controller;

import model.LibraryItem;
import java.util.ArrayList;
import java.util.List;

// Linear Search (Can search by any field, even if unsorted)
public List<LibraryItem> searchByAuthor(String author) {
    List<LibraryItem> results = new ArrayList<>();
    for (LibraryItem item : items) {
        if (item.getAuthor().equalsIgnoreCase(author)) results.add(item);
    }
    return results;
}

public class SearchEngine {
    public static List<LibraryItem> linearSearchByTitle(List<LibraryItem> items, String title) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                result.add(item);
            }
        }
        return result;
    }
}


