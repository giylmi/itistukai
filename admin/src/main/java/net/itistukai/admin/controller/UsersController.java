package net.itistukai.admin.controller;

import net.itistukai.admin.service.IAdminService;
import net.itistukai.admin.validator.UserValidator;
import net.itistukai.core.dao.IUserDao;
import net.itistukai.core.domain.User;
import net.itistukai.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by giylmi on 06.01.15.
 */
@Controller
public class UsersController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdminService adminService;

    @InitBinder("user")
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(new UserValidator());
    }

    @RequestMapping("users")
    public String users(Model model){
        model.addAttribute("usersTotal", userService.count());
        model.addAttribute("adminsTotal", adminService.count());
        return "users";
    }

    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public String register(@Valid User user, String password_confirmation, BindingResult result){
        if(!user.getPassword().equals(password_confirmation)) result.rejectValue("password", "notEquals");
        return "redirect:users";
    }
}
