//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Book;
import model.LibraryItem;

public class Sorting {
    public static void mergeSort(List<LibraryItem> list, Comparator<LibraryItem> comparator) {
        if (list.size() >= 2) {
            int mid = list.size() / 2;
            List<LibraryItem> left = new ArrayList(list.subList(0, mid));
            List<LibraryItem> right = new ArrayList(list.subList(mid, list.size()));
            mergeSort(left, comparator);
            mergeSort(right, comparator);
            merge(list, left, right, comparator);
        }
    }

    private static void merge(List<LibraryItem> list, List<LibraryItem> left, List<LibraryItem> right, Comparator<LibraryItem> comp) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.size() && j < right.size()) {
            if (comp.compare((LibraryItem)left.get(i), (LibraryItem)right.get(j)) <= 0) {
                list.set(k++, (LibraryItem)left.get(i++));
            } else {
                list.set(k++, (LibraryItem)right.get(j++));
            }
        }

        while(i < left.size()) {
            list.set(k++, (LibraryItem)left.get(i++));
        }

        while(j < right.size()) {
            list.set(k++, (LibraryItem)right.get(j++));
        }

    }

    public static void selectionSort(List<LibraryItem> items) {
        int n = items.size();

        for(int i = 0; i < n - 1; ++i) {
            int minIndex = i;

            for(int j = i + 1; j < n; ++j) {
                if (((LibraryItem)items.get(j)).getTitle().compareTo(((LibraryItem)items.get(minIndex)).getTitle()) < 0) {
                    minIndex = j;
                }
            }

            Collections.swap(items, i, minIndex);
        }

    }

    public static void insertionSort(List<LibraryItem> items) {
        int n = items.size();

        for(int i = 1; i < n; ++i) {
            LibraryItem key = (LibraryItem)items.get(i);

            int j;
            for(j = i - 1; j >= 0 && ((LibraryItem)items.get(j)).getTitle().compareTo(key.getTitle()) > 0; --j) {
                items.set(j + 1, (LibraryItem)items.get(j));
            }

            items.set(j + 1, key);
        }

    }

    public static class LibraryComparators {
        public static Comparator<LibraryItem> byTitle() {
            return Comparator.comparing(LibraryItem::getTitle, String.CASE_INSENSITIVE_ORDER);
        }

        public static Comparator<LibraryItem> byAuthor() {
            return (a, b) -> {
                String authorA = a instanceof Book ? ((Book)a).getAuthor() : "";
                String authorB = b instanceof Book ? ((Book)b).getAuthor() : "";
                return authorA.compareToIgnoreCase(authorB);
            };
        }

        public static Comparator<LibraryItem> byYear() {
            return Comparator.comparingInt(LibraryItem::getYear);
        }
    }
}
