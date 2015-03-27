package net.itistukai.core.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.itistukai.core.Constants;
import net.itistukai.core.dao.*;
import net.itistukai.core.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by giylmi on 03.03.2015.
 */

@EnableScheduling
@Service
@Profile("uploadOn")
public class VKDownloadJob {

    private Logger logger = LoggerFactory.getLogger(VKDownloadJob.class);

    @Autowired
    VideoDao videoDao;
    @Autowired
    InstagramVideoDao instagramVideoDao;
    @Autowired
    InstagramUserDao instagramUserDao;
    @Autowired
    PartsDao partsDao;

    @PostConstruct
    public void post() {
        execute();
    }

    //
    @Scheduled(fixedDelay = 30000)
    public void execute() {
        try {
            URL url = new URL("https://api.vk.com/method/newsfeed.search?q=#" + Constants.MAIN_HASHTAG);
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            ObjectMapper mapper = new ObjectMapper();
            VkFeedsResponse response = mapper.readValue(connection.getInputStream(), VkFeedsResponse.class);
            List<VkVideo> videos = new LinkedList<>();

            for (Feed f : response.getResponse()) {
                if (f.getAttachments() != null) {
                    for (Attachment a : f.getAttachments()) {
                        if (a.getVideo() != null) {
                            videos.add(a.getVideo());
                        }
                    }
                }
            }
            //TODO save videos on DB

            //TODO merge instagram video and vk video by date

            //<iframe src="//vk.com/video_ext.php?oid=76751256&id=169875191&hash=6e1048199956affc&sd" width="426" height="240"  frameborder="0"></iframe>
            logger.info(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
