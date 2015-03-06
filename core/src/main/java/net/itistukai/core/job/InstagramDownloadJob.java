package net.itistukai.core.job;

import com.google.common.collect.Lists;
import net.itistukai.core.Constants;
import net.itistukai.core.dao.VideoDao;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.core.domain.instagram.InstagramUser;
import net.itistukai.core.domain.instagram.InstagramVideo;
import org.jinstagram.Instagram;
import org.jinstagram.entity.tags.TagMediaFeed;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.exceptions.InstagramException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by giylmi on 03.03.2015.
 */

@EnableScheduling
@Service
public class InstagramDownloadJob{

    @Autowired
    Instagram instagram;

    @Autowired
    VideoDao videoDao;

    @Scheduled(fixedDelay = 600000)
    public void execute(){
        try {
            TagMediaFeed feed = instagram.getRecentMediaTags(Constants.MAIN_HASHTAG);
            processFeed(feed);
        } catch (InstagramException e) {
            e.printStackTrace();
        }
    }

    private void processFeed(TagMediaFeed feed) throws InstagramException {
        if (feed != null) {
            boolean found = false;
            List<MediaFeedData> mediaFeeds = Lists.reverse(feed.getData());
            for (MediaFeedData mediaFeedData: mediaFeeds)
                if (mediaFeedData.getType().equals("video")) {
                    InstagramVideo instagramVideo = videoDao.getInstagramVideoByInstagramId(mediaFeedData.getId());
                    if (instagramVideo != null) {
                        found = true;
                    } else {
                        instagramVideo = new InstagramVideo();
                        populateInstagramVideo(mediaFeedData, instagramVideo);

                        videoDao.saveInstagramVideo(instagramVideo);
                    }
                }
            if (!found && feed.getPagination().hasNextPage()) {
                feed = instagram.getTagMediaInfoNextPage(feed.getPagination());
                processFeed(feed);
            }
        }
    }

    private void populateInstagramVideo(MediaFeedData mediaFeedData, InstagramVideo instagramVideo) {
        instagramVideo.setInstagramId(mediaFeedData.getId());
        instagramVideo.setInstagramUrl(mediaFeedData.getLink());

        populateInstagramUser(mediaFeedData, instagramVideo);

        instagramVideo.setDate(new DateTime(Long.valueOf(mediaFeedData.getCreatedTime())));
        instagramVideo.setStatus(VideoStatus.NEW);
        instagramVideo.setUrl(mediaFeedData.getVideos().getStandardResolution().getUrl());
    }

    private void populateInstagramUser(MediaFeedData mediaFeedData, InstagramVideo instagramVideo) {
        instagramVideo.setInstagramUser(new InstagramUser());
        instagramVideo.getInstagramUser().setId(mediaFeedData.getUser().getId());
        instagramVideo.getInstagramUser().setFullName(mediaFeedData.getUser().getFullName());
        instagramVideo.getInstagramUser().setProfilePicture(mediaFeedData.getUser().getProfilePictureUrl());
        instagramVideo.getInstagramUser().setUserName(mediaFeedData.getUser().getUserName());
    }
}
