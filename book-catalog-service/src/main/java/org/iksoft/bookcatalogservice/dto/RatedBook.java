package org.iksoft.bookcatalogservice.dto;

/**
 * @author Ilyos Khurozov
 */
public class RatedBook {

    private String bookId;
    private String title;
    private String author;
    private Integer rate;

    public RatedBook() {
    }

    public RatedBook(String bookId, String title, String author, Integer rate) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.rate = rate;
    }

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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
