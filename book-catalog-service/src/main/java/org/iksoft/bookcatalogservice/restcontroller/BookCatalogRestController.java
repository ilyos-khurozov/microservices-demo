package org.iksoft.bookcatalogservice.restcontroller;

import org.iksoft.bookcatalogservice.dto.RatedBook;
import org.iksoft.bookcatalogservice.dto.UserBookCatalog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Ilyos Khurozov
 */

@RestController
public class BookCatalogRestController {
    
    @GetMapping("/{userId}")
    public UserBookCatalog getUserBookCatalog(@PathVariable String userId){
        UserBookCatalog catalog = new UserBookCatalog();
        catalog.setUserId(userId);
        catalog.setBooks(new LinkedList<>());

        catalog.getBooks().addAll(Arrays.asList(
           new RatedBook("id1", "title", "author", 4),
           new RatedBook("id2", "title", "author", 4),
           new RatedBook("id3", "title", "author", 5)
        ));

        return catalog;
    }

}
