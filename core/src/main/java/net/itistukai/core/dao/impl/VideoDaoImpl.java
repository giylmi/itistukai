package net.itistukai.core.dao.impl;

import com.google.common.collect.ImmutableMap;
import net.itistukai.core.dao.VideoDao;
import net.itistukai.core.dao.adapter.DataSourceAdapter;
import net.itistukai.core.dao.adapter.QueryManager;
import net.itistukai.core.domain.instagram.InstagramVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * Created by adel on 06.03.15.
 */
@Repository
public class VideoDaoImpl implements VideoDao {

    @Autowired
    DataSourceAdapter ds;

    @Override
    public InstagramVideo getInstagramVideoByInstagramId(String id) {
        return null;
    }

    @Override
    public InstagramVideo saveInstagramVideo(InstagramVideo instagramVideo) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        ds.update(QueryManager.getQuery("sql/video/add.ftl"), keyHolder);
        Long vidId = ((Integer)keyHolder.getKeys().get("id")).longValue();
        instagramVideo.setId(vidId);
        ds.execute(QueryManager.getQuery("sql/instagram/addUser.ftl", ImmutableMap.<String, Object>builder().put("user", instagramVideo.getInstagramUser()).build()));
        ds.execute(QueryManager.getQuery("sql/instagram/addVideo.ftl", ImmutableMap.<String, Object>builder().put("video", instagramVideo).build()));
        return instagramVideo;
    }
}
