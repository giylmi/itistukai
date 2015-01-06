package net.itistukai.core.validator;

import net.itistukai.core.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by giylmi on 28.12.14.
 */
public class UserValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

    }
}
