package net.itistukai.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by adel on 22.02.15.
 */
@Configuration
@Import(value = {DaoConfig.class, ServiceConfig.class, ValidatorsConfig.class})
public class CoreConfig {
}
