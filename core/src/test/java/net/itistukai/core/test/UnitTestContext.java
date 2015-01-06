package net.itistukai.core.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by giylmi on 28.12.14.
 */
@Configuration
@TransactionConfiguration(defaultRollback = true)
public class UnitTestContext {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
