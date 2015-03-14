package net.itistukai.web.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ainurminibaev on 14.03.15.
 */
@Controller("")
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderUserLogin() {
        return "site/user_auth";
    }
}
