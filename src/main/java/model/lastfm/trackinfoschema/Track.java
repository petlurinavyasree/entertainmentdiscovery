
package model.lastfm.trackinfoschema;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "mbid",
    "url",
    "duration",
    "streamable",
    "listeners",
    "playcount",
    "artist",
    "album",
    "toptags",
    "wiki"
})
public class Track {

    @JsonProperty("name")
    private String name;
    @JsonProperty("mbid")
    private String mbid;
    @JsonProperty("url")
    private String url;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("streamable")
    private Streamable streamable;
    @JsonProperty("listeners")
    private String listeners;
    @JsonProperty("playcount")
    private String playcount;
    @JsonProperty("artist")
    private Artist artist;
    @JsonProperty("album")
    private Album album;
    @JsonProperty("toptags")
    private Toptags toptags;
    @JsonProperty("wiki")
    private Wiki wiki;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("mbid")
    public String getMbid() {
        return mbid;
    }

    @JsonProperty("mbid")
    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("streamable")
    public Streamable getStreamable() {
        return streamable;
    }

    @JsonProperty("streamable")
    public void setStreamable(Streamable streamable) {
        this.streamable = streamable;
    }

    @JsonProperty("listeners")
    public String getListeners() {
        return listeners;
    }

    @JsonProperty("listeners")
    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    @JsonProperty("playcount")
    public String getPlaycount() {
        return playcount;
    }

    @JsonProperty("playcount")
    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    @JsonProperty("artist")
    public Artist getArtist() {
        return artist;
    }

    @JsonProperty("artist")
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @JsonProperty("album")
    public Album getAlbum() {
        return album;
    }

    @JsonProperty("album")
    public void setAlbum(Album album) {
        this.album = album;
    }

    @JsonProperty("toptags")
    public Toptags getToptags() {
        return toptags;
    }

    @JsonProperty("toptags")
    public void setToptags(Toptags toptags) {
        this.toptags = toptags;
    }

    @JsonProperty("wiki")
    public Wiki getWiki() {
        return wiki;
    }

    @JsonProperty("wiki")
    public void setWiki(Wiki wiki) {
        this.wiki = wiki;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
