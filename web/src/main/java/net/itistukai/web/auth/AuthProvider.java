package net.itistukai.web.auth;


import net.itistukai.core.domain.core.User;
import net.itistukai.web.service.UserService;
import net.itistukai.web.util.PasswordHelper;
import net.itistukai.web.util.SecurityContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by ainurminibaev on 12.05.14.
 */
@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String password = authentication.getCredentials().toString();
        String login = authentication.getName();
        User user = userService.findUser(login);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        String hashedPassword = PasswordHelper.encrypt(password, user.getSalt());
        if (user.getPassword().equals(hashedPassword)) {
            return SecurityContextUtil.setAuthentication(user);
        } else {
            throw new BadCredentialsException("Bad user password");
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
