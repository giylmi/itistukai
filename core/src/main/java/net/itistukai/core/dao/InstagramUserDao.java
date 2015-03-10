package net.itistukai.core.dao;

import net.itistukai.core.domain.instagram.InstagramUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by giylmi on 09.03.2015.
 */
public interface InstagramUserDao extends CrudRepository<InstagramUser, Long> {
}
