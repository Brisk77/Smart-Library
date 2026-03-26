// Linear Search (Can search by any field, even if unsorted)
public List<LibraryItem> searchByAuthor(String author) {
    List<LibraryItem> results = new ArrayList<>();
    for (LibraryItem item : items) {
        if (item.getAuthor().equalsIgnoreCase(author)) results.add(item);
    }
    return results;
}

// Recursive Search (Example for Title)
public LibraryItem recursiveSearchByTitle(List<LibraryItem> list, String title, int index) {
    if (index >= list.size()) return null;
    if (list.get(index).getTitle().equalsIgnoreCase(title)) return list.get(index);
    return recursiveSearchByTitle(list, title, index + 1);
}





//Binary Search (Faster for soeted lists)
  
public LibraryItem binarySearchById(List<LibraryItem> sortedList, String id) {
    int low = 0;
    int high = sortedList.size() - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        int cmp = sortedList.get(mid).getId().compareTo(id);

        if (cmp < 0) low = mid + 1;
        else if (cmp > 0) high = mid - 1;
        else return sortedList.get(mid);
    }
    return null;
}
