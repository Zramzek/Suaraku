import java.io.File;
import java.util.Scanner;


class Menu {
    private Library library;
    private Scanner scanner;

    public Menu(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Save Books to File");
            System.out.println("4. Load Books from File");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> addBook();
                case 2 -> library.printData();
                case 3 -> saveBooks();
                case 4 -> loadBooks();
                case 5 -> {
                    System.out.println("Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year of publication: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book buku = new Book(title, author, year);
        library.addBuku(buku);
    }

    private void saveBooks() {
        String directoryPath = "C:\\Users\\fmaul\\IdeaProjects\\tes";

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] fileList = directory.listFiles();

            if (fileList != null) {
                System.out.println("List file: ");
                for (File file : fileList) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            }
        }
        System.out.print("Enter filename to save books: ");
        String filename = scanner.nextLine();
        library.saveBooks(filename);
    }

    private void loadBooks() {
        String directoryPath = "C:\\Users\\fmaul\\IdeaProjects\\tes";

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] fileList = directory.listFiles();

            if (fileList != null) {
                System.out.println("List file: ");
                for (File file : fileList) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            }
        }
        System.out.print("Enter filename to load books: ");
        String filename = scanner.nextLine();
        library.loadBooks(filename);
    }
}
