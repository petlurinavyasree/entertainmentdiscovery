package movie;

import model.movie.MovieData;
import model.movie.MovieResults;
import model.movie.MovieTitle;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RelatedMoviesController {
    private static final String apiKey = "6f8de39dc2efbd0ae00ca5a00e638de4";
    private static final String apiUrl = "https://api.themoviedb.org/3/discover/movie?api_key={apiKey}&language=en-US&sort_by=popularity.desc&primary_release_date.gte={startDate}&primary_release_date.lte={endDate}&with_genres={genreId}";
    private MovieGenreIdMapping movieGenreIdMapping;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat requiredDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public RelatedMoviesController() {
        this.movieGenreIdMapping = new MovieGenreIdMapping();
    }

    public Map<String, List<MovieTitle>> getRelatedMovies(List<MovieData> movieData, String startDate, String endDate) throws ParseException {
        String apiStartDate = requiredDateFormat.format(simpleDateFormat.parse(startDate));
        String apiEndDate = requiredDateFormat.format(simpleDateFormat.parse(endDate));
        MovieGenre movieGenre = new MovieGenre();
        Set<String> movieGenres = movieGenre.getMovieGenre(movieData);
        Map<String, List<MovieTitle>> relatedMovies = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        MovieResults movieResults;
        for(String genreName: movieGenres) {
          String genreId = movieGenreIdMapping.getGenreId(genreName);
          movieResults = restTemplate.getForObject(apiUrl, MovieResults.class, apiKey, apiStartDate, apiEndDate, genreId);
          relatedMovies.put(genreName, movieResults.getMovieTitles());
        }
        return relatedMovies;
    }

}
