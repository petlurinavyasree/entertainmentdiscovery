package model.movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.LinkedList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieGenreItem {
    private String genres;

    @JsonSetter("Genre")
    public void setGenre(String genres) {
        this.genres = genres;
    }

    public List<String> getGenres() {
        List<String> genresList = new LinkedList<>();
        if (genres != null && !genres.isEmpty()) {
            for (String genre : genres.split(",")) {
                genresList.add(genre.trim());
            }
        }
        return genresList;
    }
}
