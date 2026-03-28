package controller;

import model.LibraryItem;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Sorting {

    // Nested class for comparators
    public static class LibraryComparators {
        public static Comparator<LibraryItem> byTitle() {
            return Comparator.comparing(LibraryItem::getTitle, String.CASE_INSENSITIVE_ORDER);
        }

        public static Comparator<LibraryItem> byAuthor() {
            // Assuming not all items have authors, handle nulls
            return (a, b) -> {
                String authorA = (a instanceof model.Book) ? ((model.Book) a).getAuthor() : "";
                String authorB = (b instanceof model.Book) ? ((model.Book) b).getAuthor() : "";
                return authorA.compareToIgnoreCase(authorB);
            };
        }

        public static Comparator<LibraryItem> byYear() {
            return Comparator.comparingInt(LibraryItem::getYear);
        }
    }

    // Mergesort (Recursive and Efficient)
    public static void mergeSort(List<LibraryItem> list, Comparator<LibraryItem> comparator) {
        if (list.size() < 2) return;
        int mid = list.size() / 2;
        List<LibraryItem> left = new ArrayList<>(list.subList(0, mid));
        List<LibraryItem> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, comparator);
        mergeSort(right, comparator);
        merge(list, left, right, comparator);
    }

    private static void merge(List<LibraryItem> list, List<LibraryItem> left, List<LibraryItem> right, Comparator<LibraryItem> comp) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (comp.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    public static void selectionSort(List<LibraryItem> items) {
        int n = items.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (items.get(j).getTitle().compareTo(items.get(minIndex).getTitle()) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(items, i, minIndex);
        }
    }

    public static void insertionSort(List<LibraryItem> items) {
        int n = items.size();
        for (int i = 1; i < n; ++i) {
            LibraryItem key = items.get(i);
            int j = i - 1;
            while (j >= 0 && items.get(j).getTitle().compareTo(key.getTitle()) > 0) {
                items.set(j + 1, items.get(j));
                j = j - 1;
            }
            items.set(j + 1, key);
        }
    }
}
