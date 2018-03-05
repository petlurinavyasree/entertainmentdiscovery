package model.facebook;

import model.lastfm.ArtistData;
import model.movie.MovieData;

import java.util.List;

public class FacebookResponse {
    private final List<ArtistData> artistData;
    private final List<MovieData> movieData;

    public FacebookResponse(List<ArtistData> artistData, List<MovieData> movieData) {
        this.artistData = artistData;
        this.movieData = movieData;
    }

    public List<ArtistData> getArtistData() {
        return artistData;
    }

    public List<MovieData> getMovieData() {
        return movieData;
    }
}
