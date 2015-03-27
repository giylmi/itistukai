package net.itistukai.core.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by ainurminibaev on 27.03.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VkFeedsResponse {

    List<Feed> response;

    public List<Feed> getResponse() {
        return response;
    }

    public void setResponse(List<Feed> response) {
        this.response = response;
    }
}
