package net.itistukai.web.service;

import net.itistukai.core.domain.User;
import net.itistukai.web.form.UserForm;

import java.util.List;

/**
 * Created by adel on 17.01.15.
 */
public interface IUserService {

    List<User> all(boolean withPI);

    Integer count();

    User registerUser(UserForm user);

    Boolean userExists(UserForm userForm);
}
