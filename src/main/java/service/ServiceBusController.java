package service;

import facebook.FacebookController;
import lastfm.LastFmController;
import model.facebook.FacebookResponse;
import model.lastfm.ArtistData;
import model.movie.MovieTitle;
import model.service.ServiceResponse;
import movie.RelatedMoviesController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ServiceBusController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat requiredFormat = new SimpleDateFormat("yyyy-MM-dd");


    private final LastFmController lastFmController;
    private final FacebookController facebookController;
    private final ServiceResponseController serviceResponseController;
    private final RelatedMoviesController relatedMoviesController;

    public ServiceBusController() {
        this.lastFmController = new LastFmController();
        this.facebookController = new FacebookController();
        this.serviceResponseController = new ServiceResponseController();
        this.relatedMoviesController = new RelatedMoviesController();
    }


    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/discover")
    public ServiceResponse discoverEntertainment(@RequestParam(value="name", defaultValue="World") String name,
                                                 @RequestParam(value="startDate", defaultValue="01-01-2008") String startDate,
                                                 @RequestParam(value="endDate", defaultValue="01-01-2018") String endDate,
                                                 @RequestParam(value="accessToken")String accessToken) throws ParseException {
        //String accesstoken = "EAACEdEose0cBALZBdKH7oxDqXPXFGoLyBg55OhW3p1Jw4SCMjPkWUTjxQ7tYfaBRpZAeov57Ojx1sOSB9Hxm6rQjLMfTLVpS5rqxwCd1b2MDHZC5zyHJA6iLh3MyJkfhGVkJ4HWTo2yJWvwscNIYBbVZB1HQUDK6mKVb6CzIXcW17SwR2idPSGx1aC9FsdwneAS7qnpQJgZDZD\n";


        FacebookResponse response = facebookController.getFacebookData(accessToken);
        String startDateFormated = requiredFormat.format(simpleFormat.parse(startDate));
        List<ArtistData> artistData = lastFmController.getRelatedMusicInfo(response.getArtistData(), startDate, endDate);
        Map<String, List<MovieTitle>> relatedMovies = relatedMoviesController.getRelatedMovies(response.getMovieData(),startDate,endDate);
        return serviceResponseController.createServiceResponse(artistData, relatedMovies);
    }
}
