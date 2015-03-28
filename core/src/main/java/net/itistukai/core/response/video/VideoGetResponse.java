package net.itistukai.core.response.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by ainurminibaev on 28.03.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoGetResponse {

    List<VkVideoInfo> response;

    public List<VkVideoInfo> getResponse() {
        return response;
    }

    public void setResponse(List<VkVideoInfo> response) {
        this.response = response;
    }
}
