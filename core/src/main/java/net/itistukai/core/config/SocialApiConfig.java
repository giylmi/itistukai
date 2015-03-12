package net.itistukai.core.config;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by giylmi on 03.03.2015.
 */
@Configuration
//@PropertySource("classpath:/instagram-api.properties")
@ComponentScan(basePackages = {"net.itistukai.core.job"})
public class SocialApiConfig {

//    @Value("${INSTAGRAM_CLIENT_ID}")
//    public String INSTAGRAM_CLIENT_ID;
//
//    @Value("${INSTAGRAM_CLIENT_SECRET}")
//    public String INSTAGRAM_CLIENT_SECRET;
//
//    @Value("${INSTAGRAM_CALLBACK_URL}")
//    public String INSTAGRAM_CALLBACK_URL;
//
//    @Value("${INSTAGRAM_ACCESS_TOKEN}")
//    public String INSTAGRAM_ACCESS_TOKEN;
//
//    @Bean
//    public Instagram instagram(){
//        Token token = new Token(INSTAGRAM_ACCESS_TOKEN, INSTAGRAM_CLIENT_SECRET);
//        return new Instagram(token);
//    }

}
