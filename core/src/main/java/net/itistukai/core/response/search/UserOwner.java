package net.itistukai.core.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ainurminibaev on 04.04.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserOwner implements Owner {

    @JsonProperty("uid")
    private Long id;
    private String photo;
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getPhoto() {
        return photo;
    }

    @Override
    public String getName() {
        return firstName + ' ' + lastName;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
