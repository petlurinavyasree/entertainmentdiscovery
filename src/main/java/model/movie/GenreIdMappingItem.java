package model.movie;

import com.fasterxml.jackson.annotation.JsonSetter;

public class GenreIdMappingItem {
    private String id;
    private String name;

    @JsonSetter("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

