package net.itistukai.web.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by giylmi on 15.03.2015.
 */
@Component
public class DoubleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String url = request.getRequestURI();
        if (url.startsWith("/admin/logout")) response.sendRedirect("/admin");
        else response.sendRedirect("/");
    }
}
