package net.itistukai.web.service.impl;

import net.itistukai.core.dao.VideoDao;
import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.web.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by giylmi on 08.03.2015.
 */
@Service
public class VideosServiceImpl implements VideosService {

    @Autowired
    VideoDao videoDao;

    @Override
    public Long getNewVideosCount() {
        return videoDao.countVideosByStatus(VideoStatus.NEW);
    }

    @Override
    public Long getViewedVideosCount() {
        return videoDao.countVideosByStatus(VideoStatus.VIEWED);
    }

    @Override
    public Long getAcceptedVideosCount() {
        return videoDao.countVideosByStatus(VideoStatus.OK);
    }

    @Override
    public Long getBannedVideosCount() {
        return videoDao.countVideosByStatus(VideoStatus.BANNED);
    }

    @Override
    public List<Video> getVideosByStatus(VideoStatus status) {
        return videoDao.getVideosByStatus(status);
    }
}
