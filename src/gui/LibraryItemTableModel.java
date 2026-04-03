package gui;

import model.LibraryItem;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LibraryItemTableModel extends AbstractTableModel {

    private final List<LibraryItem> items;
    private final String[] columnNames = {"ID", "Title", "Author", "Year", "Type", "Available"};

    public LibraryItemTableModel(List<LibraryItem> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LibraryItem item = items.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getId();
            case 1:
                return item.getTitle();
            case 2:
                return item.getAuthor();
            case 3:
                return item.getYear();
            case 4:
                return item.getType();
            case 5:
                return item.isAvailable();
            default:
                return null;
        }
    }
}
