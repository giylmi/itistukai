package net.itistukai.core.domain.instagram;

import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by giylmi on 03.03.2015.
 */
public class InstagramVideo extends Video {
    private String instagramUrl;
    private String instagramId;
    private InstagramUser instagramUser;

    public InstagramVideo() {
    }

    public InstagramVideo(Long id, Long partId, VideoStatus status, String url, DateTime date, String instagramUrl, String instagramId, InstagramUser instagramUser) {
        super(id, partId, status, url, date);
        this.instagramUrl = instagramUrl;
        this.instagramId = instagramId;
        this.instagramUser = instagramUser;
    }

    public InstagramUser getInstagramUser() {
        return instagramUser;
    }

    public void setInstagramUser(InstagramUser instagramUser) {
        this.instagramUser = instagramUser;
    }

    public String getInstagramId() {
        return instagramId;
    }

    public void setInstagramId(String instagramId) {
        this.instagramId = instagramId;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public static RowMapper<InstagramVideo> FULL_ROW_MAPPER = new RowMapper<InstagramVideo>() {
        @Override
        public InstagramVideo mapRow(ResultSet resultSet, int i) throws SQLException {
            InstagramVideo video = new InstagramVideo();
            video.setId(resultSet.getLong("id"));
            video.setUrl(resultSet.getString("url"));
            video.setStatus(VideoStatus.byValue(resultSet.getInt("status")));
            video.setPartId(resultSet.getLong("partId"));
            video.setDate(new DateTime(Long.valueOf(resultSet.getString("date"))));
            video.setInstagramUrl(resultSet.getString("link"));
            video.setInstagramId(resultSet.getString("instagram_video_id"));

            video.setInstagramUser(InstagramUser.FULL_ROW_MAPPER.mapRow(resultSet, i));
            return video;
        }
    };
}
