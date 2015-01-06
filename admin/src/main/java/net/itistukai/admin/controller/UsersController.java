package net.itistukai.admin.controller;

import net.itistukai.core.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by giylmi on 06.01.15.
 */
@Controller
public class UsersController {

    @Autowired
    private IUserDao userDao;

    @RequestMapping
    public String users(){

    }
}
