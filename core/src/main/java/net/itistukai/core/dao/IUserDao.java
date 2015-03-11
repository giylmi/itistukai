package net.itistukai.core.dao;

import net.itistukai.core.domain.core.User;
import net.itistukai.core.domain.core.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by giylmi on 27.12.14.
 */
public interface IUserDao extends CrudRepository<User, Long> {

    Iterable<User> findAllByRole(UserRole role);

    Long countByRole(UserRole role);

    List<User> findAllByLoginOrEmail(String login, String email);
}
