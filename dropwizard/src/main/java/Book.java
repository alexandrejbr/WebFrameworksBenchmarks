public class Book {

    private final String title;
    private final String[] authors;
    private final String publisher;
    private final long isbn13;
    private final String publishedDate;

    public Book(String title, String[] authors, String publisher, long isbn13, String publishedDate) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn13 = isbn13;
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public long getIsbn13() {
        return isbn13;
    }

    public String getPublishedDate() {
        return publishedDate;
    }
}