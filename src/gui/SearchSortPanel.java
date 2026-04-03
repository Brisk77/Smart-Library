package gui;

import controller.LibraryManager;
import controller.SearchEngine;
import controller.Sorting;
import model.LibraryItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SearchSortPanel extends JPanel {

    private final LibraryManager libraryManager;
    private final JTextField searchField = new JTextField(20);
    private final JTextArea resultsArea = new JTextArea(10, 50);
    private final JComboBox<String> sortAlgorithmComboBox = new JComboBox<>(new String[]{"Selection Sort", "Insertion Sort"});

    public SearchSortPanel(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel topPanel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search by Title:"));
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);
        topPanel.add(searchPanel, BorderLayout.NORTH);

        JPanel sortPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sortPanel.add(new JLabel("Sort by Title using:"));
        sortPanel.add(sortAlgorithmComboBox);
        JButton sortButton = new JButton("Sort");
        sortPanel.add(sortButton);
        topPanel.add(sortPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        add(scrollPane, BorderLayout.CENTER);

        searchButton.addActionListener(e -> searchItems());
        sortButton.addActionListener(e -> sortItems());
    }

    private void searchItems() {
        String query = searchField.getText();
        List<LibraryItem> results = SearchEngine.linearSearchByTitle(libraryManager.getDatabase().getAllItems(), query);
        displayResults(results);
    }

    private void sortItems() {
        List<LibraryItem> items = libraryManager.getDatabase().getAllItems();
        String selectedAlgorithm = (String) sortAlgorithmComboBox.getSelectedItem();
        if ("Selection Sort".equals(selectedAlgorithm)) {
            Sorting.selectionSort(items);
        } else {
            Sorting.insertionSort(items);
        }
        displayResults(items);
    }

    private void displayResults(List<LibraryItem> results) {
        resultsArea.setText("");
        if (results.isEmpty()) {
            resultsArea.setText("No items found.");
        } else {
            for (LibraryItem item : results) {
                resultsArea.append(item.getTitle() + " by " + item.getAuthor() + "\n");
            }
        }
    }
}
