package lab12.task2;
import java.util.*;
public class RefBook extends Book {
    private String field;
    private List<Chapter> chapters;

    public RefBook(String title, int page, int publishYear, String author, int price, String field) {
        super(title, page, publishYear, author, price);
        this.field = field;
        this.chapters = new LinkedList<>();
    }

    public String getField() {
        return field;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }


    @Override
    public void addChapter(Chapter chapter, Chapter... other) {
        this.chapters.add(chapter);
        this.chapters.addAll(Arrays.asList(other));
    }

    @Override
    public String typeOfBook() {
        return "Reference Book";
    }

    @Override
    public String toString() {
        return this.title + " " + this.publishYear + " " + this.chapters;
    }
}
