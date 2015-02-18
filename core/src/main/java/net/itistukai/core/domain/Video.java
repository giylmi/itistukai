package net.itistukai.core.domain;

/**
 * Created by adel on 18.02.15.
 */
public abstract class Video {

    private Long id;
    private Long partId;
    private VideoStatus status;

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
