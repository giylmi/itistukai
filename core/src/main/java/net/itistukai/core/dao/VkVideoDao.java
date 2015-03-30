package net.itistukai.core.dao;

import net.itistukai.core.domain.vk.VkVideo;
import org.springframework.data.repository.CrudRepository;

public interface VkVideoDao extends CrudRepository<VkVideo, Long> {

    VkVideo findOneByVid(Long videoId);
}
