package net.itistukai.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ainurminibaev on 14.03.15.
 */
@ControllerAdvice
@Controller
public class ErrorController {

    private Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping(value = "/forbidden", method = RequestMethod.GET)
    public String renderError() {
        //TODO generate forbidden page
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping("404")
    public String notFound(Exception ex){
        logger.error("caught exception: ", ex);
        return "site/notFound";
    }
}
