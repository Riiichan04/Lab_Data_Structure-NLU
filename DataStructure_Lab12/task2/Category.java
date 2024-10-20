package lab12.task2;


import java.util.*;
import java.util.stream.Collectors;

public class Category {
    private List<Book> bookList;
    public Category() {
        this.bookList = new LinkedList<>();
    }

    private void add(Book book, Book... other) {
        this.bookList.add(book);
        this.bookList.addAll(Arrays.asList(other));
    }

    //Câu 6
    public int sumMoney() {
        return this.bookList.stream().mapToInt(Book::getPrice).sum();
    }
    //Câu 7
    public Book maxChapter() {
        //Filter ReferenceBook
        return bookList.stream().filter(obj -> obj instanceof RefBook)
                //Compare Max Chapter of each RefBook
                .max(Comparator.comparingInt
                        //Get a Stream of Chapter in RefBook
                        (o -> ((RefBook) o).getChapters().stream()
                                //Get Chapter that have max page
                                .max(Comparator.comparingInt(Chapter::getChapterPage))
                                //Get Chapter class to compare
                                .get().getChapterPage()
                        )
                )
                //Get Book that have maximum Chapter::getChapterPage()
                .get();
    }

    //Câu 8
    public boolean isExistBookWithName(String name) {
        return bookList.stream().anyMatch(obj -> obj.getTitle().equals(name));
    }

    //Câu 9
    public boolean isExistMagazineWithName(String magazineName) {
        return bookList.stream().anyMatch(obj -> obj instanceof Magazine && obj.getTitle().equals(magazineName));
    }

    //Câu 10
    public void sortingCategory() {
        this.bookList.sort((o1, o2) -> (o1.getTitle().compareTo(o2.getTitle())) == 0 ? o2.getPublishYear() - o1.getPublishYear() : o1.getTitle().compareTo(o2.getTitle()));
    }

    //Câu 11
    public Map<Integer, Integer> mappingCategoryWithYear() {
        return this.bookList.stream().collect(Collectors.toMap(Book::getPublishYear, obj -> 1, Integer::sum));
    }

    public static void main(String[] args) {
        Book b1 = new Magazine("A", 100, 2021, "ABC", 5000, "AAAA");
        Book b2 = new Magazine("B", 100, 2022, "ABC", 5000, "BBBB");
        Book b3 = new Magazine("C", 100, 2023, "BCD", 5000, "CCCC");

        Chapter c1 = new Chapter("S", 30);
        Chapter c2 = new Chapter("T", 400);
        Chapter c3 = new Chapter("P", 50);
        Chapter c4 = new Chapter("Z", 20);
        Chapter c5 = new Chapter("R", 10);
        Chapter c6 = new Chapter("Q", 60);

        Book b4 = new RefBook("C", 121, 2021, "BCD", 5000, "CCCC");
        Book b5 = new RefBook("E", 200, 2021, "BCD", 5000, "DDDD");
        Book b6 = new RefBook("F", 300, 2022, "BCD", 5000, "EEEE");
        b4.addChapter(c1, c2);
        b5.addChapter(c3, c4);
        b6.addChapter(c5, c6);

        Category category = new Category();
        category.add(b1, b2, b3, b4, b5, b6);

        //Only test using 100% Java 8
        //C6
        System.out.println(category.sumMoney());
        //C7
        System.out.println(category.maxChapter());
        //C8
        System.out.println(category.isExistBookWithName("S"));
        //C9
        System.out.println(category.isExistMagazineWithName("A"));
        //C10
        category.sortingCategory();
        System.out.println(Arrays.toString(category.bookList.toArray()));
        //C11
        System.out.println(category.mappingCategoryWithYear());

    }


}
