package gui;

import controller.LibraryManager;
import model.Book;
import model.Journal;
import model.LibraryItem;
import model.Magazine;
import utils.IDGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class AdminPanel extends JPanel {

    private final LibraryManager libraryManager;
    private final JTextField titleField = new JTextField();
    private final JTextField authorField = new JTextField();
    private final JTextField yearField = new JTextField();
    private final JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Book", "Magazine", "Journal"});
    private final JTextField extraField = new JTextField();
    private final JLabel extraLabel = new JLabel("ISBN:");
    private final Stack<LibraryItem> undoStack = new Stack<>();

    public AdminPanel(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Author:"));
        formPanel.add(authorField);
        formPanel.add(new JLabel("Year:"));
        formPanel.add(yearField);
        formPanel.add(new JLabel("Type:"));
        formPanel.add(typeComboBox);
        formPanel.add(extraLabel);
        formPanel.add(extraField);

        JButton addButton = new JButton("Add Item");
        JButton undoButton = new JButton("Undo Add");
        formPanel.add(undoButton);
        formPanel.add(addButton);


        add(formPanel, BorderLayout.NORTH);

        typeComboBox.addActionListener(e -> updateExtraField());
        addButton.addActionListener(e -> addItem());
        undoButton.addActionListener(e -> undoAdd());

        updateExtraField();
    }

    private void updateExtraField() {
        String selectedType = (String) typeComboBox.getSelectedItem();
        if (selectedType == null) return;
        switch (selectedType) {
            case "Book":
                extraLabel.setText("ISBN:");
                break;
            case "Magazine":
                extraLabel.setText("Issue Number:");
                break;
            case "Journal":
                extraLabel.setText("Conference Name:");
                break;
        }
    }

    private void addItem() {
        String title = titleField.getText();
        String author = authorField.getText();
        int year = Integer.parseInt(yearField.getText());
        String selectedType = (String) typeComboBox.getSelectedItem();
        String extra = extraField.getText();
        String id = IDGenerator.generateUniqueId();
        LibraryItem item = null;

        if (selectedType == null) return;
        switch (selectedType) {
            case "Book":
                item = new Book(id, title, author, year, extra);
                break;
            case "Magazine":
                item = new Magazine(id, title, author, year, Integer.parseInt(extra));
                break;
            case "Journal":
                item = new Journal(id, title, author, year, extra);
                break;
        }
        if (item != null) {
            libraryManager.addItem(item);
            undoStack.push(item);
            JOptionPane.showMessageDialog(this, "Item added successfully!");
            clearForm();
        }
    }

    private void undoAdd() {
        if (!undoStack.isEmpty()) {
            LibraryItem lastAddedItem = undoStack.pop();
            libraryManager.removeItem(lastAddedItem.getId());
            JOptionPane.showMessageDialog(this, "Last item addition has been undone.");
        } else {
            JOptionPane.showMessageDialog(this, "No actions to undo.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void clearForm() {
        titleField.setText("");
        authorField.setText("");
        yearField.setText("");
        extraField.setText("");
    }
}
