package net.itistukai.web.controller.admin;

import net.itistukai.core.form.UserForm;
import net.itistukai.core.service.IAdminService;
import net.itistukai.core.service.IUserService;
import net.itistukai.core.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by giylmi on 06.01.15.
 */
@Controller
@RequestMapping("admin")
public class UsersController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdminService adminService;

    @Autowired
    UserFormValidator userFormValidator;

    @RequestMapping("users")
    public String index(Model model, @RequestParam(value = "tab", required = false, defaultValue = "users") String tab){
        model.addAttribute("usersTotal", userService.count());
        model.addAttribute("adminsTotal", adminService.count());
        model.addAttribute("js_tab", tab);

        model.addAttribute("userForm", new UserForm());
        return "users";
    }

    @RequestMapping(value = "users/all", method = RequestMethod.POST)
    public String users(Model model){
        model.addAttribute("users", userService.all(true));
        return "users/usersTabContent";
    }

    @RequestMapping(value = "users/admins", method = RequestMethod.POST)
    public String admins(Model model){
        model.addAttribute("users", adminService.all(true));
        return "users/usersTabContent";
    }

    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public String register(@ModelAttribute UserForm userForm, BindingResult result, Model model){
        userFormValidator.validate(userForm, result);
        if (result.hasErrors()) {
            return "users/userFormTabContent";
        }
        userService.registerUser(userForm);
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("created", Boolean.TRUE);
        return "users/userFormTabContent";
    }
}
