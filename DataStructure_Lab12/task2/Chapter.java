package lab12.task2;

public class Chapter {
    private String title;
    private int chapterPage;

    public Chapter(String title, int chapterPage) {
        this.title = title;
        this.chapterPage = chapterPage;
    }

    public String getTitle() {
        return title;
    }

    public int getChapterPage() {
        return chapterPage;
    }
    @Override
    public String toString() {
        return this.chapterPage + " ";
    }
}
