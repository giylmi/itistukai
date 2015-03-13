package net.itistukai.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by adel on 17.01.15.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"net.itistukai.web.service"})
//@PropertySource("classpath:/media.properties")
public class ServiceConfig {

}
