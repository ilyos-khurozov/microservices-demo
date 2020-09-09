package org.iksoft.bookcatalogservice.dto;

import java.util.Map;

/**
 * @author Ilyos Khurozov
 */
public class UserRating {

    private String userId;
    private Map<String, Integer> ratings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Integer> getRatings() {
        return ratings;
    }

    public void setRatings(Map<String, Integer> ratings) {
        this.ratings = ratings;
    }
}
