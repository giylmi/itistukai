package net.itistukai.core.dao.custom;

import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by adel on 01.04.15.
 */
public interface VideoCustomDao {

    Page<Video> findAllByStatusNotGroupByPartId(VideoStatus status, Pageable pageable);
}
