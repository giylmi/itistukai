package net.itistukai.web.auth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by giylmi on 15.03.2015.
 */
@Component
public class DoubleUrlLoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String url = request.getRequestURI();
        if (url.startsWith("/admin/login")) response.sendRedirect("/admin/login?error=true");
        else response.sendRedirect("/login?error=true");
    }
}
