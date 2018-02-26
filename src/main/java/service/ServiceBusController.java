package service;

import facebook.FacebookController;
import lastfm.LastFmController;
import model.facebook.FacebookResponse;
import model.lastfm.ArtistData;
import model.service.ServiceResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ServiceBusController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final LastFmController lastFmController;
    private final FacebookController facebookController;
    private final ServiceResponseController serviceResponseController;

    public ServiceBusController() {
        this.lastFmController = new LastFmController();
        this.facebookController = new FacebookController();
        this.serviceResponseController = new ServiceResponseController();
    }


    @RequestMapping("/discover")
    public ServiceResponse discoverEntertainment(@RequestParam(value="name", defaultValue="World") String name) {
        String accesstoken = "EAACEdEose0cBAKVOhpNiaAv72nDjIXCMCnChPXycetyOJg5sAkHEhpj8QlN891savQEXOhk1Qrl14xi9czJnOedmR6msltUbudsKarZAj38Lepp0v3LC9rBhumNcrcgHNfeoNLcR7ZAk4rnC8d1hBkeTM5oiOgZAlEVwgmJMqL32CE9BXoVZAwjPjLwNMzlvVzxAbmCAfQZDZD";

        FacebookResponse response = facebookController.getFacebookData(accesstoken);

        List<ArtistData> artistData = lastFmController.getRelatedMusicInfo(response.getArtistData());

        return serviceResponseController.createServiceResponse(artistData, new ArrayList<>());
    }
}
