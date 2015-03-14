package net.itistukai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ainurminibaev on 14.03.15.
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/forbidden", method = RequestMethod.GET)
    public String renderError() {
        //TODO generate forbidden page
        return "redirect:/";
    }
}
