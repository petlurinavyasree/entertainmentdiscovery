package lastfm;

import model.lastfm.ArtistData;
import model.lastfm.MusicData;
import model.lastfm.toptrackschema.TopTracksMain;
import model.lastfm.toptrackschema.Toptracks;
import model.lastfm.toptrackschema.Track;
import model.lastfm.trackinfoschema.TrackinfoMain;
import model.lastfm.trackinfoschema.Wiki;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LastFmController {
    private static final String apiKey = "814eda626ae4e8613247db7f1e6d7995";
    private static final String responseFormat = "json";

    public List<ArtistData> getRelatedMusicInfo(List<ArtistData> artistData, String startDate, String endDate) {
        RestTemplate restTemplate = new RestTemplate();
        List<ArtistData> response = new ArrayList<>();

        for (ArtistData data: artistData) {
            ArtistData responseData = new ArtistData();
            String artist = data.getArtistName().replaceAll("\\s", "");
            String apiUrl = "http://ws.audioscrobbler.com/2.0/?method=artist.gettoptracks&artist="
                    + artist + "&api_key=814eda626ae4e8613247db7f1e6d7995&format=json";

            TopTracksMain tracks = restTemplate.getForObject(apiUrl, TopTracksMain.class);
            List<MusicData> trackInfo =  getTrackInfor(restTemplate, tracks, startDate, endDate);
            responseData.setArtistName(artist);
            responseData.setMusicData(trackInfo);
            response.add(responseData);
        }
        return response;
    }

    private List<MusicData> getTrackInfor(RestTemplate restTemplate, TopTracksMain topTracksMain, String startDate, String endDate) {
        List<MusicData> trackResponse = new ArrayList<>();
        Toptracks toptracks = topTracksMain.getToptracks();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Date sDate = null;
        Date eDate = null;
        Date apiDate =  null;

        if (toptracks == null) {
            return new ArrayList<>();
        }

        List<Track> trackList = topTracksMain.getToptracks().getTrack();

        try {
            for (int i = 0; i < trackList.size(); i++) {

                MusicData data = null;

                String artistName = trackList.get(i).getArtist().getName();
                String trackName = trackList.get(i).getName();
                String trackName1 = trackName.split(" - ")[0];
                artistName = artistName.replaceAll("\\s", "");
                trackName1 = trackName1.replaceAll("\\s", "");

                String URL = "http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=814eda626ae4e8613247db7f1e6d7995&artist="
                        + artistName + "&track=" + trackName1 + "&format=json";

                //System.out.println("\nArtist Name is: " + artistName + " and Track is: " + trackName1);

                TrackinfoMain getInfo = restTemplate.getForObject(URL, TrackinfoMain.class);

               // System.out.println("============Release Date for the track ============");
                try {
                    Wiki wiki = getInfo.getTrack().getWiki();
                    String date = wiki.getPublished();
                    sDate = sdf1.parse(startDate);
                    eDate = sdf1.parse(endDate);
                    apiDate = sdf.parse(date);
                    if(!apiDate.equals(null))
                        if(apiDate.after(sDate) && apiDate.before(eDate))
                        {
                            data = new MusicData();
                            data.setTrackName(getInfo.getTrack().getName());
                            data.setReleaseDate(apiDate);
                            trackResponse.add(data);
                        }
                   // System.out.println("Date is: " + date);
                } catch (NullPointerException e) {
                   // System.out.println("Release date for track name " + trackName + " is not available.");
                }

              //  System.out.println(
                //        "=========================================================================================");


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return trackResponse;
    }

}
