package net.itistukai.web.interceptor;

import net.itistukai.web.config.WebApplicationContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by giylmi on 13.03.2015.
 */
public class StaticMappingInjectionInterceptor extends HandlerInterceptorAdapter {



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) return;

        String staticMapping = WebApplicationContextAware.applicationContext.getEnvironment().getProperty("static.mapping");
        modelAndView.addObject("staticMapping", staticMapping);
    }
}
