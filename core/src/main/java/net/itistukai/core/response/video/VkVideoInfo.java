package net.itistukai.core.response.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ainurminibaev on 28.03.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VkVideoInfo {

    @JsonProperty("vid")
    private Long id;

    @JsonProperty("owner_id")
    private Long ownerId;

    private Long date;

    @JsonProperty("image_medium")
    private String image;

    @JsonProperty("player")
    private String player;

    private String description;


    public VkVideoInfo(Integer number) {
        //ignore this, for jackson only
        //object according to vk.com API
    }

    public VkVideoInfo() {
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
