package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import model.movie.MovieTitle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "relatedMusic",
        "relatedMovies"
})
public class ServiceResponse {

    @JsonProperty("relatedMusic")
    private List<RelatedMusic> relatedMusic = null;
    @JsonProperty("relatedMovies")
    private Map<String,List<MovieTitle>> relatedMovies = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("relatedMusic")
    public List<RelatedMusic> getRelatedMusic() {
        return relatedMusic;
    }

    @JsonProperty("relatedMusic")
    public void setRelatedMusic(List<RelatedMusic> relatedMusic) {
        this.relatedMusic = relatedMusic;
    }

    @JsonProperty("relatedMovies")
    public Map<String,List<MovieTitle>> getRelatedMovies() {
        return relatedMovies;
    }

    @JsonProperty("relatedMovies")
    public void setRelatedMovies(Map<String, List<MovieTitle>> relatedMovies) {
        this.relatedMovies = relatedMovies;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("relatedMusic", relatedMusic).append("relatedMovies", relatedMovies).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(relatedMovies).append(additionalProperties).append(relatedMusic).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServiceResponse) == false) {
            return false;
        }
        ServiceResponse rhs = ((ServiceResponse) other);
        return new EqualsBuilder().append(relatedMovies, rhs.relatedMovies).append(additionalProperties, rhs.additionalProperties).append(relatedMusic, rhs.relatedMusic).isEquals();
    }

}
