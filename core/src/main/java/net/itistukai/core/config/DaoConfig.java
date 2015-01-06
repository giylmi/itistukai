package net.itistukai.core.config;

import net.itistukai.core.dao.adapter.DataSourceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by giylmi on 27.12.14.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"net.itistukai.core.dao"})
@PropertySource("classpath:database-local.properties")
public class DaoConfig {

    @Value("${jdbc.user}")
    public String jdbcUser;
    @Value("${jdbc.password}")
    public String jdbcPassword;
    @Value("${jdbc.driver}")
    public String jdbcDriver;
    @Value("${jdbc.url}")
    public String jdbcUrl;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

    @Bean
    @Autowired
    public DataSourceAdapter dataSourceAdapter(DataSource dataSource){
        DataSourceAdapter dataSourceAdapter = new DataSourceAdapter();
        dataSourceAdapter.setDataSource(dataSource);
        return dataSourceAdapter;
    }

    @Bean
    @Autowired
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource);
        return manager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
