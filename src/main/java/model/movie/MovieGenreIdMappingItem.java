package model.movie;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class MovieGenreIdMappingItem {
    private List<GenreIdMappingItem> genreIds;

    public List<GenreIdMappingItem> getGenreIds() {
        return genreIds;
    }
    @JsonSetter("genres")
    public void setGenreIds(List<GenreIdMappingItem> genreIds) {
        this.genreIds = genreIds;
    }
}
