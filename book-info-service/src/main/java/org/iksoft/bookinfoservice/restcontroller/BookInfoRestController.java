package org.iksoft.bookinfoservice.restcontroller;

import org.iksoft.bookinfoservice.dto.BookInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ilyos Khurozov
 */

@RestController
public class BookInfoRestController {
    
    @GetMapping("/{bookId}")
    public BookInfo getBookInfo(@PathVariable String bookId){
        BookInfo info = new BookInfo();
        info.setBookId(bookId);
        info.setAuthor("Author");
        info.setTitle("Title");

        return info;
    }

}
