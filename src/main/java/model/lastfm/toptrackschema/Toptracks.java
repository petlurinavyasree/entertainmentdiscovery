
package model.lastfm.toptrackschema;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "track",
    "@attr"
})
public class Toptracks {

    @JsonProperty("track")
    private List<Track> track = null;
    @JsonProperty("@attr")
    private Attr_ attr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("track")
    public List<Track> getTrack() {
        return track;
    }

    @JsonProperty("track")
    public void setTrack(List<Track> track) {
        this.track = track;
    }

    @JsonProperty("@attr")
    public Attr_ getAttr() {
        return attr;
    }

    @JsonProperty("@attr")
    public void setAttr(Attr_ attr) {
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
