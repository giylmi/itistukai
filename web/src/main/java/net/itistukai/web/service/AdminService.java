package net.itistukai.web.service;

import net.itistukai.core.domain.core.User;

/**
 * Created by giylmi on 25.02.2015.
 */
public interface AdminService {

    public Iterable<User> all();

    Long count();
}
