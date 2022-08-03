package io.javabrains.moviecatalogservice.resources;


import io.javabrains.moviecatalogservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

//    @RequestMapping("/{userId}")
//    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//
//        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);
//
//        return ratings.getUserRating().stream().map(rating -> {
//            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//            //System.out.print("Url:"+movie);
//            return new CatalogItem(movie.getName(), "Hi! Dhavan", rating.getRating());
//        }).collect(Collectors.toList());
//
//
////        for(Ratings rating : ratings){
////            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
////            new CatalogItem(movie.getName(), "desc", rating.getRating());
////
//
//
//        //return Collections.singletonList(new CatalogItem("Seven","Thriller", 4));
//
//    }
    @RequestMapping("/{userId}")
    public MovieCatalog getCatalog(@PathVariable("userId") String userId) {

        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);
        MovieCatalog movieCatalog = new MovieCatalog();
        movieCatalog.setMovieCatalog(ratings.getUserRating().stream().map(rating -> {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
        //System.out.print("Url:"+movie);
        return new CatalogItem(movie.getName(), "Hi! Dhavan", rating.getRating());
        }).collect(Collectors.toList()));

        return movieCatalog;


//        for(Ratings rating : ratings){
//            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
//            new CatalogItem(movie.getName(), "desc", rating.getRating());
//


    //return Collections.singletonList(new CatalogItem("Seven","Thriller", 4));
    }
}
