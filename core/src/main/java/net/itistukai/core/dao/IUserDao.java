package net.itistukai.core.dao;

import net.itistukai.core.domain.core.User;
import net.itistukai.core.domain.core.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.RowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by giylmi on 27.12.14.
 */
public interface IUserDao extends CrudRepository<User, Long> {

}
