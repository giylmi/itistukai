package net.itistukai.admin.validator;

import net.itistukai.core.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by adel on 18.02.15.
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getLogin() == null) errors.reject("login", "null");
        if (user.getEmail() == null) errors.reject("email", "null");
        if (user.getPassword() == null) errors.reject("password", "null");
        if (user.getPi() == null) errors.reject("pi", "null");
        else {
            if (user.getPi().getFirstName() == null) errors.reject("pi.first", "null");
            if (user.getPi().getLastName() == null) errors.reject("pi.last", "null");
        }
        if (user.getRole() == null) errors.reject("role", "null");
    }
}
