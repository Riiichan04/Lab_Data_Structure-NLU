package lab12.task2;

public class Magazine extends Book{
    private String name;
    public Magazine(String title, int page, int publishYear, String author, int price, String name) {
        super(title, page, publishYear, author, price);
        this.name = name;
    }


    @Override
    public void addChapter(Chapter chapter, Chapter... other) {
        return ;
    }

    @Override
    public String typeOfBook() {
        return "Magazine";
    }

    @Override
    public String toString() {
        return this.title + " " + this.publishYear;
    }
}
