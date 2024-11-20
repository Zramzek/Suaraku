import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Library implements Serializable {

    private List<Book> listBuku = new ArrayList<>();
    private Scanner scanner;

    public void addBuku(Book book) {

        listBuku.add(book);
        System.out.println("Book added: " + book);
    }

    public void printData() {
        if (listBuku.isEmpty()) {
            System.out.println("No Books in Library");
        } else {
            for (Book list : listBuku) {
                System.out.println("Judul buku: " + list.title
                        + "\nPenulis Buku: " + list.author
                        + "\nRilis: " + list.year);
            }
        }
    }

    public void saveBooks(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(listBuku);
            System.out.println("Books saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public void loadBooks(String filename) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            listBuku = (ArrayList<Book>) ois.readObject();
            System.out.println("Books loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("E1: " + e.getMessage());
        }
    }
}
