package net.itistukai.core.job;

import net.itistukai.core.Constants;
import net.itistukai.core.dao.*;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.core.domain.vk.VkVideo;
import net.itistukai.core.response.search.*;
import net.itistukai.core.response.video.VideoGetResponse;
import net.itistukai.core.response.video.VkVideoInfo;
import net.itistukai.core.util.Requests;
import net.itistukai.core.util.VkUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by giylmi on 03.03.2015.
 */

@EnableScheduling
@Service
public class VKDownloadJob {

    private static String HASH_TAG_REGEX = "[##]+([A-Za-z0-9-_]+)";
    private static Pattern HASH_TAG_PATTERN = Pattern.compile(HASH_TAG_REGEX);

    private Logger logger = LoggerFactory.getLogger(VKDownloadJob.class);

    @Autowired
    VideoDao videoDao;
    @Autowired
    VkVideoDao vkVideoDao;
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
            String urlStr = Constants.VK_API_PREFIX + "newsfeed.search?q=" + "video" + "&count=200";
            VkFeedsResponse response = Requests.requestForObject(urlStr, VkFeedsResponse.class);
            List<VkVideoAttachment> videos = new LinkedList<>();

            for (Feed f : response.getResponse()) {
                if (f.getAttachments() != null) {
                    for (Attachment a : f.getAttachments()) {
                        if (a.getVideo() != null) {
                            if (vkVideoDao.findOneByVid(a.getVideo().getId()) == null) {
                                videos.add(a.getVideo());
                            }
                        }
                    }
                }
            }

            if (videos.size() == 0) {
                return;
            }

            StringBuilder videoIds = new StringBuilder();
            for (int i = 0; i < videos.size(); i++) {
                VkVideoAttachment video = videos.get(i);
                videoIds.append(getRequestName(video));
                if (i + 1 != videos.size()) {
                    videoIds.append(',');
                }
            }

            Map<String, Object> params = new HashMap<>();
            params.put("access_token", Constants.TOKEN);
            params.put("videos", videoIds.toString());


            VideoGetResponse videoGetResponse = Requests.requestForObject(Constants.VK_API_PREFIX + "video.get?" + Requests.getRequestParams(params), VideoGetResponse.class);
            for (VkVideoInfo videoInfo : videoGetResponse.getResponse()) {
                if (videoInfo.getId() == null) {
                    continue;
                }
                VkVideo vkVideo = new VkVideo();
                vkVideo.setDate(new DateTime(videoInfo.getDate()));
                try {
                    Matcher matcher = HASH_TAG_PATTERN.matcher(videoInfo.getDescription());
                    String partHashTag = matcher.group();
                    Long partId = Long.parseLong(partHashTag.replaceAll("[\\D]", ""));
                    vkVideo.setPart(partsDao.findOne(partId));
                } catch (Exception e) {
                    //TODO remove this and just continue
                    //continue;
                    vkVideo.setPart(partsDao.findAll().iterator().next());
                }
                vkVideo.setPreloaderUrl(videoInfo.getImage());
                vkVideo.setUrl(VkUtils.parseVideoUrl(videoInfo.getPlayer()));
                if (vkVideo.getUrl() == null) {
                    continue;
                }
                vkVideo.setOwnerId(videoInfo.getOwnerId());
                vkVideo.setVid(videoInfo.getId());
                vkVideo.setStatus(VideoStatus.NEW);
                vkVideoDao.save(vkVideo);
            }

            //<iframe src="//vk.com/video_ext.php?oid=76751256&id=169875191&hash=6e1048199956affc&sd" width="426" height="240"  frameborder="0"></iframe>
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getRequestName(VkVideoAttachment video) {
        return video.getOwnerId() + "_" + video.getId();
    }


}
