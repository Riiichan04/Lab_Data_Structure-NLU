package lab12.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new LinkedList<>();
    }

    public void addBook(Book book, Book... otherBook) {
        this.books.add(book);
        this.books.addAll(Arrays.asList(otherBook));
    }

    public Book getOldestBook() {
        return books.stream().min((o1, o2) -> o1.getYear() - o2.getYear()).get();
    }

    public Map<Integer, List<Book>> getBooksByYear() {
        return books.stream().collect(Collectors.groupingBy(Book::getYear));
    }

    public Set<Book> findBooks(String authorName, int year) {
        return books.stream().
                filter((book) -> book.isAuthorAndYear(authorName, year))
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Book::getTitle))));
    }

    public static void main(String[] args) {
        Author a1 = new Author("AAA", 1020);
        Author a2 = new Author("CCC", 1940);
        Author a3 = new Author("DDD", 1500);
        Author a4 = new Author("OOO", 2000);

        Book b1 = new Book("JustABook", "OMGOMG", 10000, "Cooking", 2020);
        Book b2 = new Book("UhHuh", "OwO", 30000, "Novel", 1060);
        Book b3 = new Book("OtherBook", "SoMuchBook", 20202020, "Cooking", 2020);

        b1.addAuthor(a2, a3, a4);
        b2.addAuthor(a1);
        b3.addAuthor(a2, a3);

        Library l = new Library("Library");
        l.addBook(b1, b2, b3);
        System.out.println(l.getOldestBook());
        System.out.println(l.getBooksByYear());
        System.out.println(l.findBooks("AAA", 1060));
    }
}
