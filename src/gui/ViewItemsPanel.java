package gui;

import controller.LibraryManager;
import model.LibraryItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewItemsPanel extends JPanel {

    private final LibraryManager libraryManager;
    private JTextArea displayArea;

    public ViewItemsPanel(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;

        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        JButton refreshButton = new JButton("Refresh");

        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        add(refreshButton, BorderLayout.SOUTH);

        refreshButton.addActionListener(e -> loadItems());

        // Load items on startup
        loadItems();
    }

    private void loadItems() {
        List<LibraryItem> items = libraryManager.getAllItems();

        StringBuilder sb = new StringBuilder();

        for (LibraryItem item : items) {
            sb.append("ID: ").append(item.getId()).append("\n");
            sb.append("Title: ").append(item.getTitle()).append("\n");
            sb.append("Author: ").append(item.getAuthor()).append("\n");
            sb.append("Year: ").append(item.getYear()).append("\n");
            sb.append("------------------------\n");
        }

        displayArea.setText(sb.toString());
    }
}
