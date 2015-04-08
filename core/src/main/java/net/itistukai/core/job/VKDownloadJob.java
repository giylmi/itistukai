package net.itistukai.core.job;

import net.itistukai.core.Constants;
import net.itistukai.core.dao.*;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.core.domain.core.VideoType;
import net.itistukai.core.domain.vk.VkOwner;
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
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EnableScheduling
@Service
@Profile("uploadOn")
public class VKDownloadJob {

    private static String HASH_TAG_REGEX = "[##]+([A-Za-z0-9-_]+)";
    private static Pattern HASH_TAG_PATTERN = Pattern.compile(HASH_TAG_REGEX);

    private Logger logger = LoggerFactory.getLogger(VKDownloadJob.class);

    @Autowired
    VideoDao videoDao;
    @Autowired
    VkVideoDao vkVideoDao;
    @Autowired
    VkOwnerDao vkOwnerDao;
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
            //TODO add pageable search of feed's in case feed count GT 200
            String urlStr = Constants.VK_API_PREFIX + "newsfeed.search?q=" + Constants.MAIN_HASHTAG + "&count=200&extended=1";
            VkFeedsResponse response = Requests.requestForObject(urlStr, VkFeedsResponse.class);
            List<VkVideoAttachment> videos = new LinkedList<>();
            Map<Long, Owner> ownerMap = new HashMap<>();
            for (Feed f : response.getResponse()) {
                if (f.getAttachments() != null) {
                    for (Attachment a : f.getAttachments()) {
                        if (a.getVideo() != null) {
                            if (vkVideoDao.findOneByVid(a.getVideo().getId()) == null) {
                                videos.add(a.getVideo());
                                if (f.getGroup() != null) {
                                    ownerMap.put(a.getVideo().getId(), f.getGroup());
                                } else if (f.getUser() != null) {
                                    ownerMap.put(a.getVideo().getId(), f.getUser());
                                }
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
                    if (!partHashTag.startsWith("part")) {
                        continue;
                    }
                    Long partId = Long.parseLong(partHashTag.replaceAll("[\\D]", ""));
                    vkVideo.setPart(partsDao.findOne(partId));
                } catch (Exception e) {
                    continue;
                    //vkVideo.setPart(partsDao.findAll().iterator().next());
                }
                vkVideo.setPreloaderUrl(videoInfo.getImage());
                vkVideo.setUrl(VkUtils.parseVideoUrl(videoInfo.getPlayer()));
                if (vkVideo.getUrl() == null) {
                    continue;
                }
                vkVideo.setVid(videoInfo.getId());
                vkVideo.setStatus(VideoStatus.NEW);
                vkVideo.setVideoType(VideoType.VK);
                Owner owner = ownerMap.get(videoInfo.getId());
                if (owner != null) {
                    VkOwner vkOwner = new VkOwner();
                    vkOwner.setOwnerId(videoInfo.getOwnerId());
                    vkOwner.setOwnerPhoto(owner.getPhoto());
                    vkOwner.setOwnerName(owner.getName());
                    vkOwner = vkOwnerDao.save(vkOwner);
                    vkVideo.setVkOwner(vkOwner);
                }
                vkVideoDao.save(vkVideo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getRequestName(VkVideoAttachment video) {
        return video.getOwnerId() + "_" + video.getId();
    }


}
