//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gui;

import controller.LibraryManager;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import model.Book;
import model.Journal;
import model.Magazine;
import utils.IDGenerator;

public class MainWindow extends JFrame {
    private LibraryManager libraryManager;

    public MainWindow() {
        this.setTitle("SLCAS");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        ImageIcon icon = new ImageIcon("src/resources/mivalogo.png");
        this.setIconImage(icon.getImage());
        this.libraryManager = new LibraryManager();
        this.addSampleData();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("View Items", new ViewItemsPanel(this.libraryManager));
        tabbedPane.addTab("Borrow/Return", new BorrowReturnPanel(this.libraryManager));
        tabbedPane.addTab("Admin", new AdminPanel(this.libraryManager));
        tabbedPane.addTab("Search & Sort", new SearchSortPanel(this.libraryManager));
        this.add(tabbedPane, "Center");
    }

    private void addSampleData() {
        this.libraryManager.addItem(new Book(IDGenerator.generateUniqueId(), "The Lord of the Rings", "J.R.R. Tolkien", 1954, "978-0-618-64015-7"));
        this.libraryManager.addItem(new Magazine(IDGenerator.generateUniqueId(), "National Geographic", "National Geographic Society", 2023, 12));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Nature", "Nature Portfolio", 2024, "0028-0836"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The Lancet", "Elsevier", 2023, "0140-6736"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Science", "AAAS", 2024, "0036-8075"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Journal of Finance", "Wiley-Blackwell", 2022, "0022-1082"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Harvard Business Review", "Harvard Business Publishing", 2023, "0017-8012"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Cell", "Elsevier", 2024, "0092-8674"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The Economist", "Economist Group", 2024, "0013-0613"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Journal of Clinical Oncology", "ASCO", 2023, "0732-183X"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "IEEE Spectrum", "IEEE", 2024, "0018-9235"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "National Geographic", "National Geographic Society", 2023, "0027-9358"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Journal of the American Chemical Society", "ACS Publications", 2024, "0002-7863"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The New England Journal of Medicine", "Massachusetts Medical Society", 2023, "0028-4793"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Astronomy & Astrophysics", "EDP Sciences", 2024, "0004-6361"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Journal of Machine Learning Research", "Microtome Publishing", 2022, "1532-4435"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Scientific American", "Springer Nature", 2023, "0036-8733"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The Journal of Philosophy", "Journal of Philosophy, Inc.", 2021, "0022-362X"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Quarterly Journal of Economics", "Oxford University Press", 2024, "0033-5533"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Neurology", "American Academy of Neurology", 2023, "0028-3878"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "Psychological Bulletin", "American Psychological Association", 2022, "0033-2909"));
        this.libraryManager.addItem(new Journal(IDGenerator.generateUniqueId(), "The Art Bulletin", "College Art Association", 2023, "0004-3079"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> (new MainWindow()).setVisible(true));
    }
}
