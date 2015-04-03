package net.itistukai.core.response.search;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ainurminibaev on 27.03.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment {
    private String type;

    private VkVideoAttachment video;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VkVideoAttachment getVideo() {
        return video;
    }

    public void setVideo(VkVideoAttachment video) {
        this.video = video;
    }
}
