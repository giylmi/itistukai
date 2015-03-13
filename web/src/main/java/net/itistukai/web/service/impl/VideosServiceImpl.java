package net.itistukai.web.service.impl;

import net.itistukai.core.dao.VideoDao;
import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.web.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
        return videoDao.countByStatus(VideoStatus.NEW);
    }

    @Override
    public Long getViewedVideosCount() {
        return videoDao.countByStatus(VideoStatus.VIEWED);
    }

    @Override
    public Long getAcceptedVideosCount() {
        return videoDao.countByStatus(VideoStatus.OK);
    }

    @Override
    public Long getBannedVideosCount() {
        return videoDao.countByStatus(VideoStatus.BANNED);
    }

    @Override
    public List<Video> getVideosByStatus(VideoStatus status) {
        return videoDao.findAllByStatus(status);
    }

    @Override
    public List<Video> getVideosByStatus(VideoStatus status, int page) {
        PageRequest pageable = new PageRequest(page - 1, 15);
        return videoDao.findAllByStatus(status, pageable);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoDao.findOne(id);
    }

    @Override
    public Video saveVideo(Video video) {
        return videoDao.save(video);
    }

    @Override
    public List<Video> getGalleryVideos(int page) {
        Pageable pageable = new PageRequest(page - 1, 15, Sort.Direction.DESC, "date");
        List<Video> content = videoDao.findAll(pageable).getContent();
        List<Video> videos = new ArrayList<>(content.size());
        Collections.copy(videos, content);
        for(Iterator<Video> iterator = videos.iterator(); iterator.hasNext(); ){
            Video video = iterator.next();
            if (video.getStatus() == VideoStatus.BANNED) iterator.remove();
        }
        return videos;
    }
}
