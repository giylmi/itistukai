package net.itistukai.web.controller.admin;

import net.itistukai.web.form.UserForm;
import net.itistukai.web.service.AdminService;
import net.itistukai.web.service.UserService;
import net.itistukai.web.validator.UserFormValidator;
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
public class UsersAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    UserFormValidator userFormValidator;

    @RequestMapping("users")
    public String index(Model model, @RequestParam(value = "tab", required = false, defaultValue = "users") String tab){
        populateDashboard(model);
        model.addAttribute("js_tab", tab);

        model.addAttribute("userForm", new UserForm());
        return "admin/users/users";
    }

    public void populateDashboard(Model model) {
        model.addAttribute("usersTotal", userService.count());
        model.addAttribute("adminsTotal", adminService.count());
    }

    @RequestMapping(value = "users/all", method = RequestMethod.POST)
    public String users(Model model){
        populateDashboard(model);
        model.addAttribute("users", userService.all());
        return "admin/users/usersTabContentWrapper";
    }

    @RequestMapping(value = "users/admins", method = RequestMethod.POST)
    public String admins(Model model){
        populateDashboard(model);
        model.addAttribute("users", adminService.all());
        return "admin/users/usersTabContentWrapper";
    }

    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public String register(@ModelAttribute UserForm userForm, BindingResult result, Model model){
        userFormValidator.validate(userForm, result);
        if (result.hasErrors()) {
            populateDashboard(model);
            return "admin/users/userFormTabContentWrapper";
        }
        userService.registerUser(userForm);
        populateDashboard(model);
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("created", Boolean.TRUE);
        return "admin/users/userFormTabContentWrapper";
    }
}
