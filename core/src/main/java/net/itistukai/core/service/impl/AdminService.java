package net.itistukai.core.service.impl;

import com.google.common.collect.Lists;
import net.itistukai.core.dao.IUserDao;
import net.itistukai.core.domain.User;
import net.itistukai.core.domain.UserRole;
import net.itistukai.core.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by giylmi on 25.02.2015.
 */
@Service
public class AdminService implements IAdminService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> all(boolean withPI) {
        IUserDao.UserQueryParameters.Builder parameters = IUserDao.UserQueryParameters.builder();
        parameters.withRole(Lists.newArrayList(UserRole.ADMIN));
        if (withPI) parameters.withPI(Boolean.TRUE);
        return userDao.all(parameters.build());
    }

    @Override
    public Integer count() {
        return userDao.count(IUserDao.UserQueryParameters.builder().withRole(Lists.newArrayList(UserRole.ADMIN)).build());
    }
}
