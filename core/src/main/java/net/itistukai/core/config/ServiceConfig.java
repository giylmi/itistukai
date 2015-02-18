package net.itistukai.core.config;

import org.jinstagram.Instagram;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * Created by adel on 17.01.15.
 */
@Configuration
@ComponentScan(basePackages = {"net.itistukai.core.service"})
@PropertySource("classpath:instagram-api.properties")
public class ServiceConfig {

    @Value("INSTAGRAM_CLIENT_ID")
    public static String INSTAGRAM_CLIENT_ID;

    @Value("INSTAGRAM_CLIENT_SECRET")
    public static String INSTAGRAM_CLIENT_SECRET;

    @Value("INSTAGRAM_CALLBACK_URL")
    public static String INSTAGRAM_CALLBACK_URL;

    @Bean
    public InstagramService instagramService(){
        return new InstagramAuthService()
                .apiKey(INSTAGRAM_CLIENT_ID)
                .apiSecret(INSTAGRAM_CLIENT_SECRET)
                .callback(INSTAGRAM_CALLBACK_URL)
                .build();
    }

}
