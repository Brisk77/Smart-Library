package gui;

import controller.LibraryManager;
import javax.swing.*;
import java.awt.*;

public class BorrowReturnPanel extends JPanel {

    private final LibraryManager libraryManager;
    private final JTextField itemIdField = new JTextField();
    private final JTextField userIdField = new JTextField();

    public BorrowReturnPanel(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        add(new JLabel("Item ID:"));
        itemIdField.setColumns(10);
        add(itemIdField);

        add(new JLabel("User ID:"));
        userIdField.setColumns(10);
        add(userIdField);

        JButton borrowButton = new JButton("Borrow");
        add(borrowButton);

        JButton returnButton = new JButton("Return");
        add(returnButton);

        borrowButton.addActionListener(e -> borrowItem());
        returnButton.addActionListener(e -> returnItem());
    }

    private void borrowItem() {
        String itemId = itemIdField.getText();
        String userId = userIdField.getText();
        boolean success = libraryManager.processBorrow(userId, itemId);
        if (success) {
            JOptionPane.showMessageDialog(this, "Item borrowed successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Item could not be borrowed. Check if the item and user exist, and if the item is available.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void returnItem() {
        String itemId = itemIdField.getText();
        String userId = userIdField.getText();
        libraryManager.processReturn(userId, itemId);
        JOptionPane.showMessageDialog(this, "Item return processed. Check item status to confirm.");
    }
}
