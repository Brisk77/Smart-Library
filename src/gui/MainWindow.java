package gui;

import controller.LibraryManager;
import model.Book;
import model.Journal;
import model.Magazine;
import utils.IDGenerator;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private LibraryManager libraryManager;

    public MainWindow() {
        setTitle("SLCAS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the application icon
        ImageIcon icon = new ImageIcon("src/resources/mivalogo.png");
        setIconImage(icon.getImage());

        libraryManager = new LibraryManager();
        addSampleData();

        JTabbedPane tabbedPane = new JTabbedPane();

        // Add panels to the tabbed pane
        tabbedPane.addTab("View Items", new ViewItemsPanel(libraryManager));
        tabbedPane.addTab("Borrow/Return", new BorrowReturnPanel(libraryManager));
        tabbedPane.addTab("Admin", new AdminPanel(libraryManager));
        tabbedPane.addTab("Search & Sort", new SearchSortPanel(libraryManager));

        add(tabbedPane, BorderLayout.CENTER);
    }

    private void addSampleData() {
        libraryManager.addItem(new Book(IDGenerator.generateUniqueId(), "The Lord of the Rings", "J.R.R. Tolkien", 1954, "978-0-618-64015-7"));
        libraryManager.addItem(new Magazine(IDGenerator.generateUniqueId(), "National Geographic", "National Geographic Society", 2023, 12));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Nature", "Nature Portfolio", 2024, "0028-0836"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The Lancet", "Elsevier", 2023, "0140-6736"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Science", "AAAS", 2024, "0036-8075"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Journal of Finance", "Wiley-Blackwell", 2022, "0022-1082"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Harvard Business Review", "Harvard Business Publishing", 2023, "0017-8012"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Cell", "Elsevier", 2024, "0092-8674"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The Economist", "Economist Group", 2024, "0013-0613"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Journal of Clinical Oncology", "ASCO", 2023, "0732-183X"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "IEEE Spectrum", "IEEE", 2024, "0018-9235"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "National Geographic", "National Geographic Society", 2023, "0027-9358"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Journal of the American Chemical Society", "ACS Publications", 2024, "0002-7863"));libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The New England Journal of Medicine", "Massachusetts Medical Society", 2023, "0028-4793"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Astronomy & Astrophysics", "EDP Sciences", 2024, "0004-6361"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Journal of Machine Learning Research", "Microtome Publishing", 2022, "1532-4435"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Scientific American", "Springer Nature", 2023, "0036-8733"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The Journal of Philosophy", "Journal of Philosophy, Inc.", 2021, "0022-362X"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Quarterly Journal of Economics", "Oxford University Press", 2024, "0033-5533"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Neurology", "American Academy of Neurology", 2023, "0028-3878"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Psychological Bulletin", "American Psychological Association", 2022, "0033-2909"));
        libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The Art Bulletin", "College Art Association", 2023, "0004-3079"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }
}
