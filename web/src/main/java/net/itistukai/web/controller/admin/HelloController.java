package net.itistukai.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by giylmi on 02.01.15.
 */
@Controller
@RequestMapping("admin")
public class HelloController {

    @RequestMapping("")
    public String hello(){
        return "hello";
    }
}
