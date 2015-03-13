package net.itistukai.web.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by giylmi on 13.03.2015.
 */
public class WebApplicationContextAware implements ApplicationContextAware {
    public static  ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        WebApplicationContextAware.applicationContext = applicationContext;
    }
}
