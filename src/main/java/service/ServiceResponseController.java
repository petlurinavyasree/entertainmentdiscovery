package service;

import model.lastfm.ArtistData;
import model.lastfm.MusicData;
import model.movie.MovieData;
import model.service.RelatedMovie;
import model.service.RelatedMusic;
import model.service.ServiceResponse;
import model.service.Track;

import java.util.ArrayList;
import java.util.List;

public class ServiceResponseController {

    public ServiceResponse createServiceResponse(List<ArtistData> artistData, List<MovieData> movieData) {
        ServiceResponse response = new ServiceResponse();
        List<RelatedMusic> relatedMusic = getRelatedMusic(artistData);
        response.setRelatedMusic(relatedMusic);

        // Add movie response..
        List<RelatedMovie> relatedMovies = getRelatedMovies(movieData);
        response.setRelatedMovies(relatedMovies);

        return response;
    }

    private List<RelatedMusic> getRelatedMusic(List<ArtistData> artistData) {
        List<RelatedMusic> relatedMusic = new ArrayList<>();

        for (ArtistData data: artistData) {
            RelatedMusic music = new RelatedMusic();
            List<Track> musicTracks = new ArrayList<>();
            music.setArtist(data.getArtistName());
            for (MusicData musicData: data.getMusicData()) {
                Track track = new Track();
                track.setName(musicData.getTrackName());
                musicTracks.add(track);
            }
            music.setTracks(musicTracks);
            relatedMusic.add(music);
        }
        return relatedMusic;
    }

    private List<RelatedMovie> getRelatedMovies(List<MovieData> movieData) {
        return new ArrayList<>();
    }
}
