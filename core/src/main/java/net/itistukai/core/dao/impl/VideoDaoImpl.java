package net.itistukai.core.dao.impl;

import com.google.common.collect.ImmutableMap;
import net.itistukai.core.dao.VideoDao;
import net.itistukai.core.dao.adapter.DataSourceAdapter;
import net.itistukai.core.dao.adapter.QueryManager;
import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.core.domain.instagram.InstagramUser;
import net.itistukai.core.domain.instagram.InstagramVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adel on 06.03.15.
 */
@Repository
public class VideoDaoImpl implements VideoDao {

    @Autowired
    DataSourceAdapter ds;

    @Override
    public InstagramVideo getInstagramVideoByInstagramId(String id) {
        List<InstagramVideo> videos = ds.query(QueryManager.getQuery("sql/instagram/getByInstagramId.ftl", ImmutableMap.<String, Object>builder().put("id", id).build()), InstagramVideo.FULL_ROW_MAPPER);
        return (videos == null || videos.isEmpty()) ? null : videos.get(0);
    }

    @Override
    @Transactional
    public InstagramVideo saveInstagramVideo(InstagramVideo instagramVideo) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        ds.update(QueryManager.getQuery("sql/video/add.ftl", ImmutableMap.<String, Object>builder().put("video", instagramVideo).build()), keyHolder);
        Long vidId = ((Integer)keyHolder.getKeys().get("id")).longValue();
        instagramVideo.setId(vidId);
        if (getInstagramUserById(instagramVideo.getInstagramUser().getId()) == null)
            saveInstagramUser(instagramVideo.getInstagramUser());
        ds.execute(QueryManager.getQuery("sql/instagram/addVideo.ftl", ImmutableMap.<String, Object>builder().put("video", instagramVideo).build()));
        return instagramVideo;
    }

    public InstagramUser getInstagramUserById(String id){
        List<InstagramUser> users = ds.query(QueryManager.getQuery("sql/instagram/getUserById.ftl", ImmutableMap.<String, Object>builder().put("id", id).build()), InstagramUser.FULL_ROW_MAPPER);
        return (users == null || users.isEmpty()) ? null : users.get(0);
    }

    @Transactional
    public InstagramUser saveInstagramUser(InstagramUser instagramUser) {
        ds.execute(QueryManager.getQuery("sql/instagram/addUser.ftl", ImmutableMap.<String, Object>builder().put("user", instagramUser).build()));
        return instagramUser;
    }

    @Override
    public List<Video> getVideosByStatus(VideoStatus status) {
        List<Video> videos = ds.query(QueryManager.getQuery("sql/instagram/getVideosByStatus.ftl", ImmutableMap.<String, Object>builder().put("status", status).build()), new RowMapper<Video>() {
            @Override
            public Video mapRow(ResultSet resultSet, int i) throws SQLException {
                //TODO generify
                return InstagramVideo.FULL_ROW_MAPPER.mapRow(resultSet, i);
            }
        });
        return videos == null ? new ArrayList<Video>() : videos;
    }

    @Override
    public Long countVideosByStatus(VideoStatus status) {
        return ds.query(QueryManager.getQuery("sql/instagram/countVideosByStatus.ftl", ImmutableMap.<String, Object>builder().put("status", status).build()), new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                resultSet.next();
                return resultSet.getLong("count");
            }
        });
    }
}
