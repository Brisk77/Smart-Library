package gui;

import controller.LibraryManager;

import javax.swing.*;
import java.awt.*;

public class ReportsPanel extends JPanel {

    private final LibraryManager libraryManager;

    public ReportsPanel(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;

        setLayout(new BorderLayout());

        JTextArea reportArea = new JTextArea();

        JPanel buttonPanel = new JPanel();

        JButton totalItems = new JButton("Total Items");
        JButton borrowedItems = new JButton("Borrowed Items");
        JButton availableItems = new JButton("Available Items");

        buttonPanel.add(totalItems);
        buttonPanel.add(borrowedItems);
        buttonPanel.add(availableItems);

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        totalItems.addActionListener(e ->
                reportArea.setText("Total Items: " + libraryManager.getAllItems().size()));

        borrowedItems.addActionListener(e ->
                reportArea.setText("Borrowed Items feature coming soon"));

        availableItems.addActionListener(e ->
                reportArea.setText("Available Items feature coming soon"));
    }
}
