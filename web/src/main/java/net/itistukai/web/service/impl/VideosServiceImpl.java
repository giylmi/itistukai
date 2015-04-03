package net.itistukai.web.service.impl;

import net.itistukai.core.Constants;
import net.itistukai.core.dao.VideoDao;
import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.web.service.VideosService;
import net.itistukai.web.sort.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Page<Video> getVideosByStatus(VideoStatus status, int page) {
        PageRequest pageable = new PageRequest(page - 1, Constants.VIDEOS_PAGE_SIZE, SortType.BY_DATE_DESC.getDirection(), SortType.BY_DATE_DESC.getFieldName());
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
    @Transactional
    public Page getGalleryVideos(int page, Long partId, boolean hideRepeat, SortType sort) {

        Pageable pageable = new PageRequest(page - 1, Constants.VIDEOS_PAGE_SIZE, sort.getDirection(), sort.getFieldName());
        Page<Video> videos;
        if (hideRepeat) {
            videos = videoDao.findGalleryVideosUniqueParted(VideoStatus.BANNED, pageable);
        } else {
            if (partId == null) {
                videos = videoDao.findAllByStatusNot(VideoStatus.BANNED, pageable);
            } else videos = videoDao.findAllByStatusNotAndPartId(VideoStatus.BANNED, pageable, partId);
        }
        return videos;
    }
}
