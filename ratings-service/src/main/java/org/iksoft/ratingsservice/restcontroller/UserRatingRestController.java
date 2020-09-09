package org.iksoft.ratingsservice.restcontroller;

import org.iksoft.ratingsservice.dto.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Ilyos Khurozov
 */

@RestController
public class UserRatingRestController {
    
    @GetMapping("/{userId}")
    public UserRating getBookInfo(@PathVariable String userId){
        HashMap<String, Integer> ratings = new HashMap<>();

        ratings.put("b105", 5);
        ratings.put("b482", 4);
        ratings.put("b376", 5);

        UserRating rating = new UserRating();
        rating.setRatings(ratings);
        rating.setUserId(userId);

        return rating;
    }

}
