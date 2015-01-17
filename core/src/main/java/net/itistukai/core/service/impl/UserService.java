package net.itistukai.core.service.impl;

import net.itistukai.core.dao.IUserDao;
import net.itistukai.core.domain.User;
import net.itistukai.core.service.IUserService;
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
    public List<User> all() {
        return userDao.all();
    }
}
