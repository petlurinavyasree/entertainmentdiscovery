
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
    "#text",
    "fulltrack"
})
public class Streamable {

    @JsonProperty("#text")
    private String text;
    @JsonProperty("fulltrack")
    private String fulltrack;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("#text")
    public String getText() {
        return text;
    }

    @JsonProperty("#text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("fulltrack")
    public String getFulltrack() {
        return fulltrack;
    }

    @JsonProperty("fulltrack")
    public void setFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
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
