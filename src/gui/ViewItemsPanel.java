package gui;

import controller.LibraryManager;
import javax.swing.*;
import java.awt.*;

public class ViewItemsPanel extends JPanel {

    public ViewItemsPanel(LibraryManager libraryManager) {
        setLayout(new BorderLayout());

        // Create a table to display library items
        LibraryItemTableModel model = new LibraryItemTableModel(libraryManager.getDatabase().getAllItems());
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }
}
