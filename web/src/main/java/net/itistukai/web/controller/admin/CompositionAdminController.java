package net.itistukai.web.controller.admin;

import net.itistukai.core.domain.core.CompositionStatus;
import net.itistukai.web.form.CompositionForm;
import net.itistukai.web.service.CompositionService;
import net.itistukai.web.validator.CompositionFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by giylmi on 03.03.2015.
 */
@Controller
@RequestMapping("admin")
public class CompositionAdminController {

    @Autowired
    CompositionFormValidator compositionFormValidator;

    @Autowired
    CompositionService compositionService;

    @RequestMapping("compositions")
    public String index(Model model, @RequestParam(required = false, defaultValue = "on") String tab){
        model.addAttribute("compositionsOn", compositionService.countOn());
        model.addAttribute("compositionsArchived", compositionService.countArchived());
        if (!model.containsAttribute("compositionForm")) model.addAttribute("compositionForm", new CompositionForm());
        model.addAttribute("js_tab", tab);
        return "admin/composition/composition";
    }

    @RequestMapping(value = "compositions/upload", method = RequestMethod.POST)
    public String upload(CompositionForm compositionForm, Model model){
        compositionForm.setStatus(CompositionStatus.ON);
        BindingResult result = new BeanPropertyBindingResult(compositionForm, "compositionForm");
        compositionFormValidator.validate(compositionForm, result);
        if (!result.hasErrors()){
            compositionService.saveComposition(compositionForm);
            model.addAttribute("compositionForm", new CompositionForm());
            model.addAttribute("created", Boolean.TRUE);
        }
        return index(model, "js-composition-new");
    }
}
