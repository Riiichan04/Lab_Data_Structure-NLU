package lab9.task2;

import java.util.ArrayList;
import java.util.List;

public class RefBook extends Book{
    private String type;
    private List<Chapter> chapters;

    public RefBook(String title, int page, int year, String author, int price, String type) {
        super(title, page, year, author, price);
        this.type = type;
        this.chapters = new ArrayList<>();
    }
    //Câu 6
    @Override
    public String typeOfBook() {
        return "Reference Book";
    }
    //Câu 7
    @Override
    public boolean checkTypeAndYear(int now) {
        return false;
    }
    //Câu 10
    public int getMaxChap() {
        int result = 0;
        for (Chapter chapter : chapters) {
            if (chapter.getChapPage() > result) result = chapter.getChapPage();
        }
        return result;
    }
    //Câu 11
    @Override
    public boolean isMagazineHaveName(String name) {
        return false;
    }
    @Override
    public String toString() {
        return this.title + " " + this.year;
    }
    @Override
    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }
}
