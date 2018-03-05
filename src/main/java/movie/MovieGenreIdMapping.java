package movie;

import model.movie.GenreIdMappingItem;
import model.movie.MovieGenreIdMappingItem;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class MovieGenreIdMapping {
    private static final String apiKey = "6f8de39dc2efbd0ae00ca5a00e638de4";
    private static final String apiUrl = "https://api.themoviedb.org/3/genre/movie/list?api_key={apiKey}&language=en-US";
    private Map<String, String> genreNameIdHashMap = new HashMap<>();

    public MovieGenreIdMapping() {
        getGenreIdMapping();
    }

    public void getGenreIdMapping() {
        RestTemplate restTemplate = new RestTemplate();
        MovieGenreIdMappingItem movieGenreIdMappingItem = restTemplate.getForObject(apiUrl, MovieGenreIdMappingItem.class, apiKey);
        for(GenreIdMappingItem genreIdMappingItem : movieGenreIdMappingItem.getGenreIds()) {
            genreNameIdHashMap.put(genreIdMappingItem.getName(), genreIdMappingItem.getId());
        }
    }

    public String getGenreId(String genreName) {
        return genreNameIdHashMap.get(genreName);
    }


}
