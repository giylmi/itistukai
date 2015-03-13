package net.itistukai.web.validator;

import net.itistukai.web.form.CompositionForm;
import net.itistukai.web.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * Created by giylmi on 03.03.2015.
 */
@Component
public class CompositionFormValidator {

    @Autowired
    CompositionService compositionService;

    public void validate(CompositionForm form, Errors errors){
        if (form.getName().isEmpty()) errors.rejectValue("name", "required");
        else if (compositionService.existsName(form.getName())) errors.rejectValue("name", "exists");
        if (form.getFile() == null || form.getFile().isEmpty()) errors.rejectValue("file", "required");
//        if (form.getPoster() == null || form.getPoster().isEmpty()) errors.rejectValue("poster", "required");
    }
}
