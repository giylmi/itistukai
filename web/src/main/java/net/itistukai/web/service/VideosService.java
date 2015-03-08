package net.itistukai.web.service;

import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;

import java.util.List;

/**
 * Created by giylmi on 07.03.2015.
 */
public interface VideosService {


    Long getNewVideosCount();

    Long getViewedVideosCount();

    Long getAcceptedVideosCount();

    Long getBannedVideosCount();

    List<Video> getVideosByStatus(VideoStatus status);
}
