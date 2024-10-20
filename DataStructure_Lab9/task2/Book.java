package lab9.task2;

public abstract class Book {
    protected String title;
    protected int page;
    protected int year;
    protected String author;
    protected int price;

    public Book(String title, int page, int year, String author, int price) {
        this.title = title;
        this.page = page;
        this.year = year;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPage() {
        return page;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    //Câu 6
    public abstract String typeOfBook();

    //Câu 7
    public abstract boolean checkTypeAndYear(int now);

    //Câu 8
    public boolean isSameTypeAndAuthor(Book other) {
        return this.getClass() == other.getClass() && this.getAuthor().equals(other.getAuthor());
    }
    //Câu 10
    public abstract int getMaxChap();
    //Câu 11
    public abstract boolean isMagazineHaveName(String name);
    //Câu 12
    public boolean isSameYear(int year) {
        return this.getYear() == year;
    }

    public abstract void addChapter(Chapter chapter);
}
