package net.itistukai.core.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by ainurminibaev on 27.03.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {
    Integer count;

    private Long id;

    private Long date;
    @JsonProperty("owner_id")
    private Long ownerId;

    List<Attachment> attachments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Feed(Integer count) {
        this.count = count;
    }

    public Feed() {
    }
}
