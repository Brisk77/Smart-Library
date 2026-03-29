package gui;

import controller.LibraryManager;
import model.Book;
import utils.IDGenerator;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {

    private final LibraryManager libraryManager;

    private JTextField titleField, authorField, yearField;

    public AdminPanel(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;

        setLayout(new BorderLayout());

        // FORM PANEL
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        titleField = new JTextField();
        authorField = new JTextField();
        yearField = new JTextField();

        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);

        formPanel.add(new JLabel("Author:"));
        formPanel.add(authorField);

        formPanel.add(new JLabel("Year:"));
        formPanel.add(yearField);

        add(formPanel, BorderLayout.CENTER);

        // BUTTON PANEL
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Book");
        JButton deleteButton = new JButton("Delete Item");
        JButton undoButton = new JButton("Undo");
        JButton reportButton = new JButton("Reports");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(reportButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // ADD FUNCTION
        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String author = authorField.getText();
                int year = Integer.parseInt(yearField.getText());

                String id = IDGenerator.generateUniqueId();

                Book book = new Book(id, title, author, year);

                libraryManager.addItem(book);

                JOptionPane.showMessageDialog(this, "Book added successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // DELETE FUNCTION
        deleteButton.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Item ID:");

            if (id != null) {
                boolean removed = libraryManager.removeItem(id);

                if (removed) {
                    JOptionPane.showMessageDialog(this, "Item deleted!");
                } else {
                    JOptionPane.showMessageDialog(this, "Item not found!");
                }
            }
        });

        // UNDO (simple placeholder)
        undoButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Undo feature coming soon"));

        // REPORT BUTTON
        reportButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Use Reports Tab"));
    }
}
