import java.io.Serializable;

/**
 *
 * @author fmaul
 */
public class Book implements Serializable{
    protected String title, author;
    protected int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }


}
