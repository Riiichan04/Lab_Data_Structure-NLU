package lab12.task2;

public abstract class Book {
    protected String title;
    protected int page;
    protected int publishYear;
    protected String author;
    protected int price;
    public Book(String title, int page, int publishYear, String author, int price) {
        this.title = title;
        this.page = page;
        this.publishYear = publishYear;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPage() {
        return page;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public abstract void addChapter(Chapter chapter, Chapter... other);

    //Câu 3
    public abstract String typeOfBook();
    //Câu 4
    public boolean isPublished10YrsAgo(int currentYear) {
        return currentYear - this.publishYear == 10;
    }
    //Câu 5
    public boolean isBookSameTypeAndAuthor(Book otherBook) {
        return false;
    }
}
