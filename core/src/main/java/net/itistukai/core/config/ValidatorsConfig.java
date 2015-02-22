package net.itistukai.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by adel on 22.02.15.
 */
@Configuration
@ComponentScan(basePackages = {"net.itistukai.core.validator"})
public class ValidatorsConfig {
}
