package org.iksoft.bookcatalogservice.restcontroller;

import org.iksoft.bookcatalogservice.dto.BookInfo;
import org.iksoft.bookcatalogservice.dto.RatedBook;
import org.iksoft.bookcatalogservice.dto.UserBookCatalog;
import org.iksoft.bookcatalogservice.dto.UserRating;
import org.iksoft.bookcatalogservice.service.BookCatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

/**
 * @author Ilyos Khurozov
 */

@RestController
public class BookCatalogRestController {

    private final BookCatalogService bookCatalogService;

    public BookCatalogRestController(BookCatalogService bookCatalogService) {
        this.bookCatalogService = bookCatalogService;
    }

    @GetMapping("/{userId}")
    public UserBookCatalog getUserBookCatalog(@PathVariable String userId){
        UserBookCatalog catalog = new UserBookCatalog();
        catalog.setUserId(userId);

        UserRating userRating = bookCatalogService.getUserRating(userId);

        LinkedList<RatedBook> books = new LinkedList<>();
        userRating.getRatings().forEach((bookId, rate) -> {
            BookInfo bookInfo = bookCatalogService.getBookInfo(bookId);

            books.add(new RatedBook(
                    bookInfo.getBookId(),
                    bookInfo.getTitle(),
                    bookInfo.getAuthor(),
                    rate
            ));
        });
        catalog.setBooks(books);

        return catalog;
    }

}
