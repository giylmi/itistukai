package net.itistukai.core.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ainurminibaev on 27.03.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VkVideo {
    @JsonProperty("vid")
    private Long id;

    @JsonProperty("owner_id")
    private Long ownerId;

    private Long date;

    @JsonProperty("access_key")
    private String hash;

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
