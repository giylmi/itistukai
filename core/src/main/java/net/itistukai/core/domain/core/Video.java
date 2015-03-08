package net.itistukai.core.domain.core;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by adel on 18.02.15.
 */
public abstract class Video {

    public static Video mapVideo(Video video, ResultSet resultSet, int i) throws SQLException {
        video.setId(resultSet.getLong("id"));
        video.setDate(new DateTime(Long.valueOf(resultSet.getString("date"))));
        video.setPartId(resultSet.getLong("partId"));
        video.setUrl(resultSet.getString("url"));
        video.setStatus(VideoStatus.byValue(resultSet.getInt("status")));
        return video;
    }
    private Long id;
    private Long partId;
    private VideoStatus status;
    private String url;
    private DateTime date = DateTime.now();

    public Video() {
    }

    public Video(Long id, Long partId, VideoStatus status, String url, DateTime date) {
        this.id = id;
        this.partId = partId;
        this.status = status;
        this.url = url;
        this.date = date;
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
