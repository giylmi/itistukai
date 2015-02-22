package net.itistukai.core.util;

import net.itistukai.core.domain.User;
import net.itistukai.core.form.UserForm;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * Created by adel on 22.02.15.
 */
public class PasswordUtil {

    public static void setPasswordAndSalt(UserForm userForm, User user){
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        user.setPassword(DigestUtils.md5DigestAsHex((userForm.getPassword() + salt).getBytes()));
    }
}
