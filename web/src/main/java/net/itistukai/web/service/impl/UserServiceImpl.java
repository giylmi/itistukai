package net.itistukai.web.service.impl;

import net.itistukai.core.dao.UserDao;
import net.itistukai.core.domain.core.PersonalInformation;
import net.itistukai.core.domain.core.User;
import net.itistukai.core.domain.core.UserRole;
import net.itistukai.web.form.UserForm;
import net.itistukai.web.service.UserService;
import net.itistukai.web.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by adel on 17.01.15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Iterable<User> all() {
        return userDao.findAll();
    }

    @Override
    public long count() {
        return userDao.count();
    }

    @Override
    @Transactional
    public User registerUser(UserForm userForm) {
        User user = new User();
        user.setLogin(userForm.getLogin());
        user.setEmail(userForm.getEmail());
        user.setRole(UserRole.valueOf(userForm.getRole()));
        user.setPi(new PersonalInformation(userForm.getFirstName(), userForm.getMiddleName(), userForm.getLastName()));
        PasswordHelper.setPasswordAndSalt(userForm, user);
        return userDao.save(user);
    }

    @Override
    public Boolean userExists(UserForm userForm) {
        return !userDao.findAllByLoginOrEmail(userForm.getLogin(), userForm.getEmail()).isEmpty();
    }

    @Override
    public User findUser(String login) {
        return userDao.findOneByLogin(login);
    }
}
