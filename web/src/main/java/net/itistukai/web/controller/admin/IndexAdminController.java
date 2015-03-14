package net.itistukai.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by giylmi on 02.01.15.
 */
@Controller
@RequestMapping("admin")
public class IndexAdminController {

    @RequestMapping
    public String hello() {
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "admin/admin_auth";
    }
}
