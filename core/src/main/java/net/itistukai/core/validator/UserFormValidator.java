package net.itistukai.core.validator;

import net.itistukai.core.domain.UserRole;
import net.itistukai.core.form.UserForm;
import net.itistukai.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Created by adel on 22.02.15.
 */
@Component
public class UserFormValidator {

    @Autowired
    IUserService userService;

    public void validate(UserForm userForm, BindingResult result){
        if (userForm.getLogin().isEmpty()) result.rejectValue("login", "null");
        if (userForm.getEmail().isEmpty()) result.rejectValue("email", "null");

        boolean check = !(userForm.getLogin().isEmpty() && userForm.getEmail().isEmpty());
        if (check && userService.userExists(userForm)) result.reject("login", "exists");

        if (userForm.getPassword().isEmpty()) result.rejectValue("password", "null");
        if (userForm.getRepeatPassword().isEmpty()) result.rejectValue("repeat", "null");
        if (!userForm.getRepeatPassword().equals(userForm.getPassword())) result.rejectValue("password", "notEqual");
        if (userForm.getFirstName().isEmpty()) result.rejectValue("firstName", "null");
        if (userForm.getLastName().isEmpty()) result.rejectValue("lastName", "null");

        if (userForm.getRole().isEmpty()) result.rejectValue("role", "null");
        if (!UserRole.check(userForm.getRole())) result.rejectValue("role", "incorrect");
    }
}
