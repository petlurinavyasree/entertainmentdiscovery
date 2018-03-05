package model.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class MovieTitle {
    @JsonProperty("title")
    private String title;

    public String getTitle() {
        return title;
    }
    @JsonSetter("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
