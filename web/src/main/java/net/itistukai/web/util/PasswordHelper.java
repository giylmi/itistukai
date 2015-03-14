package net.itistukai.web.util;

import net.itistukai.core.domain.core.User;
import net.itistukai.web.form.UserForm;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * Created by ainurminibaev on 13.05.14.
 */
public class PasswordHelper {


    private static String getSaltedPass(String password, String salt) {
        return password + salt;
    }

    /**
     * Generate hash for users with own password
     */
    public static String encrypt(String unencrypted, String salt) {
        return DigestUtils.md5Hex(getSaltedPass(unencrypted, salt));
    }


    public static String generateSalt() {
        return UUID.randomUUID().toString();
    }


    public static void setPasswordAndSalt(UserForm userForm, User user) {
        user.setSalt(generateSalt());
        user.setPassword(encrypt(userForm.getPassword(), user.getSalt()));
    }
}
