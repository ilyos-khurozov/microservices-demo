package org.iksoft.bookcatalogservice.restcontroller;

import org.iksoft.bookcatalogservice.dto.BookInfo;
import org.iksoft.bookcatalogservice.dto.RatedBook;
import org.iksoft.bookcatalogservice.dto.UserBookCatalog;
import org.iksoft.bookcatalogservice.dto.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;

/**
 * @author Ilyos Khurozov
 */

@RestController
public class BookCatalogRestController {

    private final RestTemplate restTemplate;

    public BookCatalogRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userId}")
    public UserBookCatalog getUserBookCatalog(@PathVariable String userId){
        UserBookCatalog catalog = new UserBookCatalog();
        catalog.setUserId(userId);

        UserRating userRating = restTemplate.getForObject("http://ratings-service/"+userId, UserRating.class);

        LinkedList<RatedBook> books = new LinkedList<>();
        userRating.getRatings().forEach((bookId, rate) -> {
            BookInfo bookInfo = restTemplate.getForObject("http://book-info-service/"+bookId, BookInfo.class);

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
