package net.itistukai.web.config;

import net.itistukai.web.auth.PathLoginAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = {
        "net.itistukai.web.auth"
})

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PathLoginAuthenticationEntryPoint loginEntryPoint;


    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();


        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

        http
                .formLogin()
                .loginProcessingUrl("/login")
                .passwordParameter("password")
                .usernameParameter("login")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .permitAll();
        http.exceptionHandling().authenticationEntryPoint(loginEntryPoint);
        http.exceptionHandling().accessDeniedPage("/forbidden");
    }

    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {
        @Autowired
        AuthenticationProvider authenticationProvider;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider);
        }

    }
}