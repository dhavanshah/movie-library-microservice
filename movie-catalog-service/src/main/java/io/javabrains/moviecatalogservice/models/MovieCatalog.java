package io.javabrains.moviecatalogservice.models;

import java.util.List;

public class MovieCatalog {

    private List<CatalogItem> movieCatalog;

    public List<CatalogItem> getMovieCatalog() {
        return movieCatalog;
    }

    public void setMovieCatalog(List<CatalogItem> movieCatalog) {
        this.movieCatalog = movieCatalog;
    }


}
