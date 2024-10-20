package lab9.task2;

public class Magazine extends Book{
    private String name;


    public Magazine(String title, int page, int year, String author, int price, String name) {
        super(title, page, year, author, price);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Câu 6
    @Override
    public String typeOfBook() {
        return "Magazine";
    }
    //Câu 7
    @Override
    public boolean checkTypeAndYear(int now) {
        return now - this.getYear() == 10;
    }
    //Câu 10
    @Override
    public int getMaxChap() {
        return -1;
    }
    //Câu 11
    @Override
    public boolean isMagazineHaveName(String name) {
        return this.getName().equals(name);
    }

    @Override
    public void addChapter(Chapter chapter) {
    }

    @Override
    public String toString() {
        return this.title + " " + this.year;
    }

}
