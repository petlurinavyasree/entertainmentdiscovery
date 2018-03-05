package service;

import model.lastfm.ArtistData;
import model.lastfm.MusicData;
import model.movie.MovieTitle;
import model.service.RelatedMusic;
import model.service.ServiceResponse;
import model.service.Track;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceResponseController {

    public ServiceResponse createServiceResponse(List<ArtistData> artistData, Map<String,List<MovieTitle>> relatedMovies) {
        ServiceResponse response = new ServiceResponse();
        List<RelatedMusic> relatedMusic = getRelatedMusic(artistData);
        response.setRelatedMusic(relatedMusic);
        // Add movie response..
        response.setRelatedMovies(relatedMovies);
        return response;
    }

    private List<RelatedMusic> getRelatedMusic(List<ArtistData> artistData) {
        // Artist and list track
        List<RelatedMusic> relatedMusic = new ArrayList<>();
        Track track = null;
        RelatedMusic music = null;
        List<Track> trackList = null;

        for (ArtistData data: artistData) {

            music = new RelatedMusic();
            music.setArtist(data.getArtistName());
            trackList = new ArrayList<>();
            for(MusicData musicData : data.getMusicData())
            {
                if (!musicData.getTrackName().isEmpty() && !musicData.getTrackName().equals(null)) {
                    track = new Track();
                    track.setName(musicData.getTrackName());
                    track.setAdditionalProperty("ReleaseDate", (new SimpleDateFormat("dd/MM/yyyy").format(musicData.getReleaseDate())));
                    trackList.add(track);
                }
            }
            if(trackList.size() > 0) {
                music.setTracks(trackList);
                relatedMusic.add(music);
            }
        }

        return relatedMusic;
    }
}