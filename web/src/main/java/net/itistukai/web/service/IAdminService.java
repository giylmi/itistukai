package net.itistukai.web.service;

import net.itistukai.core.domain.User;

import java.util.List;

/**
 * Created by giylmi on 25.02.2015.
 */
public interface IAdminService {

    List<User> all(boolean withPI);

    Integer count();
}
