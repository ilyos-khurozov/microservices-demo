package org.iksoft.bookcatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.iksoft.bookcatalogservice.dto.BookInfo;
import org.iksoft.bookcatalogservice.dto.UserRating;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author Ilyos Khurozov
 */

@Service
public class BookCatalogService {

    private final RestTemplate restTemplate;

    public BookCatalogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallbackUserRating",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public UserRating getUserRating(String userId){
        return restTemplate.getForObject("http://ratings-service/"+userId, UserRating.class);
    }

    public UserRating getFallbackUserRating(String userId){
        HashMap<String, Integer> ratings = new HashMap<>();
        ratings.put("0",0);

        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRatings(ratings);

        return userRating;
    }

    @HystrixCommand(fallbackMethod = "getFallbackBookInfo",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000")
            }
    )
    public BookInfo getBookInfo(String bookId){
        return restTemplate.getForObject("http://book-info-service/"+bookId, BookInfo.class);
    }

    public BookInfo getFallbackBookInfo(String bookId){
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookId(bookId);
        bookInfo.setTitle("Book info not found");
        bookInfo.setAuthor("");

        return bookInfo;
    }
}
