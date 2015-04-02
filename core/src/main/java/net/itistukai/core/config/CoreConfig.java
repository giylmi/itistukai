package net.itistukai.core.config;

import net.itistukai.core.job.InstagramDownloadJob;
import net.itistukai.core.job.VKDownloadJob;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by adel on 22.02.15.
 */
@Configuration
@Import(value = {DaoConfig.class, SocialApiConfig.class, InstagramDownloadJob.class, VKDownloadJob.class})
public class CoreConfig {
}
