package net.itistukai.core.domain.core;

import org.joda.time.DateTime;

/**
 * Created by adel on 18.02.15.
 */
public abstract class Video {

    private Long id;
    private Long partId;
    private VideoStatus status;
    private String url;
    private DateTime date;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public VideoStatus getStatus() {
        return status;
    }

    public void setStatus(VideoStatus status) {
        this.status = status;
    }
}
