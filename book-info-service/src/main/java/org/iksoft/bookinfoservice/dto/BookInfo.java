package org.iksoft.bookinfoservice.dto;

/**
 * @author Ilyos Khurozov
 */
public class BookInfo {

    private String bookId;
    private String title;
    private String author;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
