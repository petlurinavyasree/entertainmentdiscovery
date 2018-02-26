
package model.lastfm.toptrackschema;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import model.lastfm.toptrackschema.Artist;
import model.lastfm.toptrackschema.Attr;
import model.lastfm.toptrackschema.Image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "playcount",
    "listeners",
    "url",
    "streamable",
    "artist",
    "image",
    "@attr"
})
public class Track {

    @JsonProperty("name")
    private String name;
    @JsonProperty("playcount")
    private String playcount;
    @JsonProperty("listeners")
    private String listeners;
    @JsonProperty("url")
    private String url;
    @JsonProperty("streamable")
    private String streamable;
    @JsonProperty("artist")
    private Artist artist;
    @JsonProperty("image")
    private List<Image> image = null;
    @JsonProperty("@attr")
    private Attr attr;
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

    @JsonProperty("playcount")
    public String getPlaycount() {
        return playcount;
    }

    @JsonProperty("playcount")
    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    @JsonProperty("listeners")
    public String getListeners() {
        return listeners;
    }

    @JsonProperty("listeners")
    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("streamable")
    public String getStreamable() {
        return streamable;
    }

    @JsonProperty("streamable")
    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    @JsonProperty("artist")
    public Artist getArtist() {
        return artist;
    }

    @JsonProperty("artist")
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @JsonProperty("image")
    public List<Image> getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(List<Image> image) {
        this.image = image;
    }

    @JsonProperty("@attr")
    public Attr getAttr() {
        return attr;
    }

    @JsonProperty("@attr")
    public void setAttr(Attr attr) {
        this.attr = attr;
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
