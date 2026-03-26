import java.util.Comparator;

public class LibraryComparators {
    public static Comparator<LibraryItem> byTitle() {
        return (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle());
    }

    public static Comparator<LibraryItem> byAuthor() {
        return (a, b) -> a.getAuthor().compareToIgnoreCase(b.getAuthor());
    }

    public static Comparator<LibraryItem> byYear() {
        return Comparator.comparingInt(LibraryItem::getYear);
    }
}



//Mergesort (Recirsive and Efficient)

public void mergeSort(List<LibraryItem> list, Comparator<LibraryItem> comparator) {
    if (list.size() < 2) return;
    int mid = list.size() / 2;
    List<LibraryItem> left = new ArrayList<>(list.subList(0, mid));
    List<LibraryItem> right = new ArrayList<>(list.subList(mid, list.size()));

    mergeSort(left, comparator);
    mergeSort(right, comparator);
    merge(list, left, right, comparator);
}

private void merge(List<LibraryItem> list, List<LibraryItem> left, List<LibraryItem> right, Comparator<LibraryItem> comp) {
    int i = 0, j = 0, k = 0;
    while (i < left.size() && j < right.size()) {
        if (comp.compare(left.get(i), right.get(j)) <= 0) list.set(k++, left.get(i++));
        else list.set(k++, right.get(j++));
    }
    while (i < left.size()) list.set(k++, left.get(i++));
    while (j < right.size()) list.set(k++, right.get(j++));
}
