package net.itistukai.admin.service.impl;

import net.itistukai.admin.service.IAdminService;
import net.itistukai.core.dao.IUserDao;
import net.itistukai.core.domain.User;
import net.itistukai.core.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adel on 22.01.15.
 */
@Service
public class AdminService implements IAdminService {

    @Autowired
    IUserDao userDao;

    @Override
    public List<User> all() {
        IUserDao.UserQueryParameters.Builder builder = IUserDao.UserQueryParameters.builder();
        builder.withRole(Arrays.asList(UserRole.ADMIN));
        return userDao.all(builder.build());
    }

    @Override
    public Integer count() {
        IUserDao.UserQueryParameters.Builder builder = IUserDao.UserQueryParameters.builder();
        builder.withRole(Arrays.asList(UserRole.ADMIN));
        return userDao.count(builder.build());
    }
}
