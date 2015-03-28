package net.itistukai.core.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ainurminibaev on 27.03.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VkVideoAttachment {
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
