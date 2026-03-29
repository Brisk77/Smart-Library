package gui;

import controller.LibraryManager;

import javax.swing.*;
import java.awt.*;

public class SearchSortPanel extends JPanel {

    private final LibraryManager libraryManager;

    public SearchSortPanel(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        JTextField searchField = new JTextField(15);
        JComboBox<String> searchType = new JComboBox<>(new String[]{"Title", "Author"});
        JComboBox<String> algorithmBox = new JComboBox<>(new String[]{"Linear", "Binary"});

        JComboBox<String> sortField = new JComboBox<>(new String[]{"Title", "Year"});
        JComboBox<String> sortAlgo = new JComboBox<>(new String[]{"Insertion", "Merge"});

        JButton searchButton = new JButton("Search");
        JButton sortButton = new JButton("Sort");

        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(searchType);
        topPanel.add(algorithmBox);
        topPanel.add(searchButton);

        topPanel.add(new JLabel("Sort by:"));
        topPanel.add(sortField);
        topPanel.add(sortAlgo);
        topPanel.add(sortButton);

        add(topPanel, BorderLayout.NORTH);

        JTextArea resultArea = new JTextArea();
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // SAFE ACTIONS (won’t conflict with teammates)
        searchButton.addActionListener(e ->
                resultArea.setText("Search feature connected. Waiting for backend logic."));

        sortButton.addActionListener(e ->
                resultArea.setText("Sort feature connected. Waiting for backend logic."));
    }
}
