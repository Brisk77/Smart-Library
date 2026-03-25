package utils;

import model.LibraryDatabase;

public class FileHandler {
    public static void saveData(LibraryDatabase database, String filePath) {
        // Implementation to save data to a file (e.g., JSON or serialized objects)
        System.out.println("Saving data to " + filePath);
    }

    public static LibraryDatabase loadData(String filePath) {
        // Implementation to load data from a file
        System.out.println("Loading data from " + filePath);
        return new LibraryDatabase();
    }
}
