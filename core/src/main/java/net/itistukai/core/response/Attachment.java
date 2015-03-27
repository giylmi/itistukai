package net.itistukai.core.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ainurminibaev on 27.03.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment {
    private String type;

    private VkVideo video;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VkVideo getVideo() {
        return video;
    }

    public void setVideo(VkVideo video) {
        this.video = video;
    }
}
