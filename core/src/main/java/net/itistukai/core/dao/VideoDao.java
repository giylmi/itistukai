package net.itistukai.core.dao;

import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.core.domain.instagram.InstagramUser;
import net.itistukai.core.domain.instagram.InstagramVideo;

import java.util.List;

/**
 * Created by giylmi on 06.03.2015.
 */
public interface VideoDao {

    InstagramVideo getInstagramVideoByInstagramId(String id);

    InstagramVideo saveInstagramVideo(InstagramVideo instagramVideo);

    InstagramUser getInstagramUserById(String id);

    InstagramUser saveInstagramUser(InstagramUser instagramUser);

    List<Video> getVideosByStatus(VideoStatus status);

    Long countVideosByStatus(VideoStatus status);
}
