package lab12.task3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Book {
    private String id;
    private String title;
    private int price;
    private String type;
    private int year;
    private List<Author> authors;

    public Book(String id, String title, int price, String type, int year) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.type = type;
        this.year = year;
        this.authors = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public void addAuthor(Author base, Author... other) {
        this.authors.add(base);
        this.authors.addAll(Arrays.asList(other));
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public boolean isBookHaveAuthor(String authorName) {
        return authors.stream().anyMatch((obj) -> obj.getName().equals(authorName));
    }

    public boolean isAuthorAndYear(String authorName, int year) {
        return this.isBookHaveAuthor(authorName) && this.getYear() == year;
    }

    @Override
    public String toString() {
        return this.id + "  " + this.authors + "  " + this.year + "  ";
    }
}
