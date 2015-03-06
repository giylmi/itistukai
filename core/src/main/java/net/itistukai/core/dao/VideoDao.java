package net.itistukai.core.dao;

import net.itistukai.core.domain.instagram.InstagramVideo;

/**
 * Created by giylmi on 06.03.2015.
 */
public interface VideoDao {

    InstagramVideo getInstagramVideoByInstagramId(String id);

    InstagramVideo saveInstagramVideo(InstagramVideo instagramVideo);
}
