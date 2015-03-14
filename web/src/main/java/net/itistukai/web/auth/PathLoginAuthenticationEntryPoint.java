package net.itistukai.web.auth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PathLoginAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public PathLoginAuthenticationEntryPoint() {
        super("/");
    }

    /**
     * @param request   the request
     * @param response  the response
     * @param exception the exception
     * @return the URL (cannot be null or empty; defaults to {@link #getLoginFormUrl()})
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request,
                                                     HttpServletResponse response,
                                                     AuthenticationException exception) {
        return getLoginUrlFromPath(request);
    }

    private String getLoginUrlFromPath(HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        if (requestUrl.contains("admin")) {
            return "/admin/login";
        } else {
            return "user/login";
        }
    }
}