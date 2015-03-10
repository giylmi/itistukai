package net.itistukai.core.dao;

import net.itistukai.core.domain.instagram.InstagramVideo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by giylmi on 09.03.2015.
 */
public interface InstagramVideoDao extends CrudRepository<InstagramVideo, Long> {

    InstagramVideo getByInstagramId(String instagramId);
}
