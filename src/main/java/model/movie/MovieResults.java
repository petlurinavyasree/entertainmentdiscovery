package model.movie;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class MovieResults {
    private List<MovieTitle> movieTitles;

    public List<MovieTitle> getMovieTitles() {
        return movieTitles;
    }

    @JsonSetter("results")
    public void setMovieTitles(List<MovieTitle> movieTitles) {
        this.movieTitles = movieTitles;
    }
}
