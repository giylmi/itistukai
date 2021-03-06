package net.itistukai.core.dao;

import net.itistukai.core.dao.custom.VideoCustomDao;
import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by giylmi on 06.03.2015.
 */
public interface VideoDao extends PagingAndSortingRepository<Video, Long>, VideoCustomDao{

    Long countByStatus(VideoStatus status);

    List<Video> findAllByStatus(VideoStatus status);

    Page<Video> findAllByStatus(VideoStatus status, Pageable pageable);

    Page<Video> findAllByStatusNot(VideoStatus status, Pageable pageable);

    Page<Video> findAllByStatusNotAndPartId(VideoStatus status, Pageable pageable, Long partId);
}
