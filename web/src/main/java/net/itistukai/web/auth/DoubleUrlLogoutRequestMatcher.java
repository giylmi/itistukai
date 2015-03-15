package net.itistukai.web.auth;

import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by giylmi on 15.03.2015.
 */
@Component
public class DoubleUrlLogoutRequestMatcher implements RequestMatcher {
    @Override
    public boolean matches(HttpServletRequest request) {
        String url = request.getRequestURI();
        return url.startsWith("/admin/logout") || url.startsWith("/logout");
    }
}
