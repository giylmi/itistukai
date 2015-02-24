package net.itistukai.core.service.impl;

import com.google.common.collect.Lists;
import net.itistukai.core.dao.IUserDao;
import net.itistukai.core.domain.PersonalInformation;
import net.itistukai.core.domain.User;
import net.itistukai.core.domain.UserRole;
import net.itistukai.core.form.UserForm;
import net.itistukai.core.service.IUserService;
import net.itistukai.core.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adel on 17.01.15.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public List<User> all(boolean withPI) {
        if (!withPI)
            return userDao.all();
        return userDao.all(IUserDao.UserQueryParameters.builder().withPI(Boolean.TRUE).build());
    }

    @Override
    public Integer count() {
        return userDao.count();
    }

    @Override
    public User registerUser(UserForm userForm) {
        User user = new User();
        user.setLogin(userForm.getLogin());
        user.setEmail(userForm.getEmail());
        user.setRole(UserRole.valueOf(userForm.getRole()));
        user.setPi(new PersonalInformation(userForm.getFirstName(), userForm.getMiddleName(), userForm.getLastName()));

        PasswordUtil.setPasswordAndSalt(userForm, user);

        return userDao.registerUser(user);
    }

    @Override
    public Boolean userExists(UserForm userForm) {
        IUserDao.UserQueryParameters.Builder builder = IUserDao.UserQueryParameters.builder();
        builder.addParam("login", userForm.getLogin());
        builder.addParam("email", userForm.getEmail());
        return userDao.count(builder.build()) > 0;
    }
}
