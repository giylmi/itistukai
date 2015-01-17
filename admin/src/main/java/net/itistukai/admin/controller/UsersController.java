package net.itistukai.admin.controller;

import net.itistukai.core.dao.IUserDao;
import net.itistukai.core.domain.User;
import net.itistukai.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by giylmi on 06.01.15.
 */
@Controller
public class UsersController {

    @Autowired
    private IUserService userService;

    @RequestMapping("users")
    public String users(Model model){
        List<User> users = userService.all();
        model.addAttribute("users", users);
        return "users";
    }
}
