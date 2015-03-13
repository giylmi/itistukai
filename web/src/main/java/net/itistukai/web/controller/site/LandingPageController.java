package net.itistukai.web.controller.site;

import net.itistukai.core.domain.core.Composition;
import net.itistukai.web.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping
public class LandingPageController {

    @Autowired
    CompositionService compositionService;

    @RequestMapping
    public String landingPage(Model model){
        Composition shurale = compositionService.getOneByName("The Shuraleh");
        model.addAttribute("composition", shurale);
        Collections.shuffle(shurale.getParts());
        model.addAttribute("randomPart", shurale.getParts().get(0));
        return "site/landing/landing";
    }

}