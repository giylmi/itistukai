package net.itistukai.core.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ainurminibaev on 04.04.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupOwner implements Owner {
    @JsonProperty("gid")
    private Long id;
    private String photo;
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
