package model.lastfm;

import java.util.List;

public class ArtistData {
    private String artistName;
    private List<MusicData> musicData;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<MusicData> getMusicData() {
        return musicData;
    }

    public void setMusicData(List<MusicData> musicData) {
        this.musicData = musicData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistData that = (ArtistData) o;

        if (!artistName.equals(that.artistName)) return false;
        return musicData.equals(that.musicData);
    }

    @Override
    public int hashCode() {
        int result = artistName.hashCode();
        result = 31 * result + musicData.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ArtistData{" +
                "artistName='" + artistName + '\'' +
                ", musicData=" + musicData +
                '}';
    }
}
