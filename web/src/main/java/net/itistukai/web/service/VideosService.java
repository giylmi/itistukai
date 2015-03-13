package net.itistukai.web.service;

import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import org.springframework.data.domain.Page;

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
    Page<Video> getVideosByStatus(VideoStatus status, int page);

    Video getVideoById(Long id);

    Video saveVideo(Video video);

    Page getGalleryVideos(int page);
}
