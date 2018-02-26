package facebook;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.Page;
import com.restfb.types.User;
import model.facebook.FacebookResponse;
import model.lastfm.ArtistData;
import model.movie.MovieData;

import java.util.ArrayList;
import java.util.List;

public class FacebookController {

    public FacebookResponse getFacebookData(String accessToken) {
        // TODO Auto-generated method stu

        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_12);

        User me = fbClient.fetchObject("me", User.class, Parameter.with("fields","email,last_name,first_name,birthday,hometown,gender,work,likes,movies,music,groups,picture,about"));

        Connection<Page> myMovies = fbClient.fetchConnection(me.getId() + "/movies", Page.class);//Page pg = fbClient.fetchObject("me/music", Page.class, Parameter.with("fields", "name"));
        List<MovieData> movieData = getMovieData(myMovies);


        Connection<Page> myMusic = fbClient.fetchConnection(me.getId() + "/music", Page.class);//Page pg = fbClient.fetchObject("me/music", Page.class, Parameter.with("fields", "name"));
        List<ArtistData> myMusicData = getMusicData(myMusic);


//        Connection<Page> myBooks = fbClient.fetchConnection(me.getId() + "/books", Page.class);//Page pg = fbClient.fetchObject("me/music", Page.class, Parameter.with("fields", "name"));
//        for(Page page:myBooks.getData()) {
//            System.out.println("Books: " + page.getName());
//        }

        return new FacebookResponse(myMusicData, movieData);
    }

    private List<ArtistData> getMusicData(Connection<Page> myMusic) {
        List<ArtistData> result = new ArrayList<>();

        for(Page page:myMusic.getData()) {
            ArtistData artistData = new ArtistData();
            artistData.setArtistName(page.getName());
            System.out.println("Music: " + page.getName());
            result.add(artistData);
        }

        return result;
    }

    private List<MovieData> getMovieData(Connection<Page> myMovies) {
        List<MovieData> result = new ArrayList<>();

        for(Page page:myMovies.getData()) {
            MovieData movieData = new MovieData();
            movieData.setMovieName(page.getName());
            System.out.println("Movies: " + page.getName());
            result.add(movieData);
        }

        return result;
    }
}
