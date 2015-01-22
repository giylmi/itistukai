package net.itistukai.admin.service;

import net.itistukai.core.domain.User;

import java.util.List;

/**
 * Created by adel on 22.01.15.
 */
public interface IAdminService {

    List<User> all();

    Integer count();
}
