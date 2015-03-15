package net.itistukai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by giylmi on 15.03.2015.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String loginPage(Model model, @RequestParam(required = false, defaultValue = "false") boolean error) {
        model.addAttribute("error", error);
        return "site/auth";
    }

    @RequestMapping(value = {"/admin/login"}, method = RequestMethod.GET)
    public String adminLoginPage(Model model, @RequestParam(required = false, defaultValue = "false") boolean error) {
        model.addAttribute("error", error);
            return "admin/auth";
    }
}
