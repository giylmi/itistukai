package net.itistukai.core.domain.core;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by adel on 18.02.15.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "VIDEO_PROVIDER")
public abstract class Video {

    @Id
    @SequenceGenerator(name = "videoGenerator", sequenceName = "video_sequence")
    @GeneratedValue(generator = "videoGenerator")
    private Long id;
    @OneToOne
    private Part part;
    private VideoStatus status;
    private String url;
    private String preloaderUrl;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime date;

    @Enumerated(EnumType.STRING)
    @Column(name = "video_type")
    private VideoType videoType;

    public String getPreloaderUrl() {
        return preloaderUrl;
    }

    @PrePersist
    public void updateFields() {
        if (status == null) {
            status = VideoStatus.NEW;
        }
    }

    public void setPreloaderUrl(String preloaderUrl) {
        this.preloaderUrl = preloaderUrl;
    }

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

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public VideoStatus getStatus() {
        return status;
    }

    public void setStatus(VideoStatus status) {
        this.status = status;
    }

    public VideoType getVideoType() {
        return videoType;
    }

    public void setVideoType(VideoType videoType) {
        this.videoType = videoType;
    }
}
