package net.itistukai.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by adel on 17.01.15.
 */
@Configuration
@ComponentScan(basePackages = {"net.itistukai.web.service"})
@PropertySource("classpath:instagram-api.properties")
public class ServiceConfig {



}
