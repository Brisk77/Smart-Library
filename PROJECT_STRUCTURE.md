# Library App Project Structure

Here is a map of the project's folder and file structure:

```
Library App/
├── .idea/              # IntelliJ IDEA project files
├── out/                # Compiled output files
├── src/                # Source code
│   ├── controller/     # Contains the business logic and controllers
│   │   ├── BorrowController.java
│   │   ├── LibraryManager.java
│   │   ├── SearchEngine.java
│   │   └── Sorting.java
│   ├── gui/            # Contains the graphical user interface components
│   │   ├── AdminPanel.java
│   │   ├── BorrowReturnPanel.java
│   │   ├── LibraryItemTableModel.java
│   │   ├── MainWindow.java
│   │   ├── SearchSortPanel.java
│   │   └── ViewItemsPanel.java
│   ├── model/          # Contains the data models (e.g., Book, UserAccount)
│   │   ├── Book.java
│   │   ├── Borrowable.java
│   │   ├── Journal.java
│   │   ├── LibraryDatabase.java
│   │   ├── LibraryItem.java
│   │   ├── Magazine.java
│   │   └── UserAccount.java
│   ├── utils/          # Contains utility classes
│   │   ├── FileHandler.java
│   │   └── IDGenerator.java
│   └── Main.java       # Main entry point of the application
├── .gitignore          # Git ignore file
└── Library App.iml     # IntelliJ IDEA module file
```
