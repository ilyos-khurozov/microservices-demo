package org.iksoft.bookcatalogservice.dto;

import java.util.List;

/**
 * @author Ilyos Khurozov
 */
public class UserBookCatalog {

    private String userId;
    private List<RatedBook> books;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<RatedBook> getBooks() {
        return books;
    }

    public void setBooks(List<RatedBook> books) {
        this.books = books;
    }
}
