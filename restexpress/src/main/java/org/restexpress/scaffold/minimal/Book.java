package org.restexpress.scaffold.minimal;

/**
 * Created by alexandrejbr on 07/05/14.
 */
public class Book
{
    public static Book[] all =
            new Book[] {
                new Book("Animal Farm", new String[]{"George Orwell"}, "Penguin", 9780141036137L, "April 27, 2014"),
                new Book("Animal Farm", new String[]{"George Orwell"}, "Penguin", 9780141036137L, "April 27, 2014"),
                new Book("Animal Farm", new String[]{"George Orwell"}, "Penguin", 9780141036137L, "April 27, 2014"),
            };

    public String title;
    public String[] authors;
    public String publisher;
    public long isbn13;
    public String publishedDate;

    public Book(String title, String[] authors, String publisher, long isbn13, String publishedDate) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn13 = isbn13;
        this.publishedDate = publishedDate;
    }
}
