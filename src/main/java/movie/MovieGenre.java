package movie;

import model.movie.MovieData;
import model.movie.MovieGenreItem;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieGenre {
    private static final String apiKey = "78bef312";
    private static final String apiUrl = "http://www.omdbapi.com/?i=tt3896198&apikey={apiKey}&t={movieName}&r=json";

    public Set<String> getMovieGenre(List<MovieData> movieData) {
        RestTemplate restTemplate = new RestTemplate();
        Set<String> movieGenres = new HashSet<>();
        for(MovieData movieName : movieData ) {
            MovieGenreItem genres = restTemplate.getForObject(apiUrl, MovieGenreItem.class, apiKey, movieName.getMovieName());
            movieGenres.addAll(genres.getGenres());
        }
        return movieGenres;
    }
}
