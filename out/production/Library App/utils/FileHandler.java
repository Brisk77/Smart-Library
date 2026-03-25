//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package utils;

import model.LibraryDatabase;

public class FileHandler {
    public static void saveData(LibraryDatabase database, String filePath) {
        System.out.println("Saving data to " + filePath);
    }

    public static LibraryDatabase loadData(String filePath) {
        System.out.println("Loading data from " + filePath);
        return new LibraryDatabase();
    }
}
