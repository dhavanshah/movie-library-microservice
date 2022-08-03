package io.javabrains.ratingsdataservice.resource;

import io.javabrains.ratingsdataservice.models.Ratings;
import io.javabrains.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsDataResource {

    @RequestMapping("/{movieId}")
    public Ratings getratingData(@PathVariable("movieId") String movieId){

        return new Ratings(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {

        List<Ratings> ratings = Arrays.asList(
                new Ratings("1234",4),
                new Ratings("5678",5)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;

    }
}
