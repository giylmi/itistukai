package net.itistukai.web.service.impl;

import net.itistukai.core.dao.UserDao;
import net.itistukai.core.domain.core.User;
import net.itistukai.core.domain.core.UserRole;
import net.itistukai.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by giylmi on 25.02.2015.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserDao userDao;

    @Override
    public Iterable<User> all() {
        return userDao.findAllByRole(UserRole.ADMIN);
    }

    @Override
    public Long count() {
        return userDao.countByRole(UserRole.ADMIN);
    }
}
