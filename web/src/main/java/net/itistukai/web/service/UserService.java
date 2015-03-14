package net.itistukai.web.service;

import net.itistukai.core.domain.core.User;
import net.itistukai.web.form.UserForm;

/**
 * Created by adel on 17.01.15.
 */
public interface UserService {

    Iterable<User> all();

    long count();

    User registerUser(UserForm user);

    Boolean userExists(UserForm userForm);

    User findUser(String login);
}
