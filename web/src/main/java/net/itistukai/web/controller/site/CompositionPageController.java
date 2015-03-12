package net.itistukai.web.controller.site;

import net.itistukai.web.service.ICompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by adel on 12.03.15.
 */
@Controller
@RequestMapping("composition")
public class CompositionPageController {

    @Autowired
    ICompositionService compositionService;

    @RequestMapping
    public String compositionPage(Model model){
        model.addAttribute("composition", compositionService.getOneByName("The Shuraleh"));

        return "composition/composition";
    }
}
