package net.itistukai.core.job;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.itistukai.core.Constants;
import net.itistukai.core.dao.InstagramUserDao;
import net.itistukai.core.dao.InstagramVideoDao;
import net.itistukai.core.dao.PartsDao;
import net.itistukai.core.dao.VideoDao;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.core.domain.instagram.InstagramUser;
import net.itistukai.core.domain.instagram.InstagramVideo;
import org.jinstagram.Instagram;
import org.jinstagram.entity.relationships.RelationshipFeed;
import org.jinstagram.entity.tags.TagMediaFeed;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.entity.users.feed.UserFeed;
import org.jinstagram.entity.users.feed.UserFeedData;
import org.jinstagram.exceptions.InstagramException;
import org.jinstagram.model.Relationship;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by giylmi on 03.03.2015.
 */

@EnableScheduling
@Service
@Profile("uploadOn")
public class InstagramDownloadJob{

    private Logger logger = LoggerFactory.getLogger(InstagramDownloadJob.class);

    @Autowired
    Instagram instagram;

    @Autowired
    VideoDao videoDao;
    @Autowired
    InstagramVideoDao instagramVideoDao;
    @Autowired
    InstagramUserDao instagramUserDao;
    @Autowired
    PartsDao partsDao;

    @Scheduled(fixedDelay = 30000)
    public void execute(){
        try {
            logger.info("request to instagram by delay");
            TagMediaFeed feed = instagram.getRecentMediaTags(Constants.MAIN_HASHTAG);
            processFeed(feed);

            logger.info("checking for new followers");
            String id = instagram.getCurrentUserInfo().getData().getId();
            Set<String> followedByIds = getFollowedByIds(id);
            Set<String> followedIds = getFollowedIds(id);
            for (String userId: Sets.difference(followedByIds, followedIds)) {
                RelationshipFeed relationshipFeed = instagram.getUserRelationship(userId);
                if (!relationshipFeed.getData().getOutgoingStatus().equals("requested")) {
                    logger.info("follow " + userId);
                    instagram.setUserRelationship(userId, Relationship.FOLLOW);
                }
            }
        } catch (InstagramException e) {
            e.printStackTrace();
        }
    }

    public Set<String> getFollowedIds(String id) throws InstagramException {
        Set<String> followedIds = new HashSet<>();
        UserFeed userFollowList = instagram.getUserFollowList(id);
        addIds(followedIds, userFollowList);
        while (userFollowList.getPagination().hasNextPage()) {
            userFollowList = instagram.getUserFollowListNextPage(userFollowList.getPagination());
            addIds(followedIds, userFollowList);
        }
        return followedIds;
    }

    public Set<String> getFollowedByIds(String id) throws InstagramException {
        Set<String> userFollowedByIds = new HashSet<>();
        UserFeed userFollowedByList = instagram.getUserFollowedByList(id);
        addIds(userFollowedByIds, userFollowedByList);
        while (userFollowedByList.getPagination().hasNextPage()) {
            userFollowedByList = instagram.getUserFollowedByListNextPage(userFollowedByList.getPagination());
            addIds(userFollowedByIds, userFollowedByList);
        }
        return userFollowedByIds;
    }

    private void addIds(Set<String> set, UserFeed userFeed) {
        Function<UserFeedData, String> feedToId = new Function<UserFeedData, String>() {
            @Override
            public String apply(UserFeedData userFeedData) {
                return userFeedData.getId();
            }
        };
        set.addAll(Lists.newArrayList(Iterables.transform(userFeed.getUserList(), feedToId)));
    }

    private void processFeed(TagMediaFeed feed) throws InstagramException {
        logger.info("processing feed");
        if (feed != null) {
            boolean found = false;
            List<MediaFeedData> mediaFeeds = Lists.reverse(feed.getData());
            for (MediaFeedData mediaFeedData: mediaFeeds) {
                if (mediaFeedData.getType().equals("video")) {
                    InstagramVideo instagramVideo = instagramVideoDao.getByInstagramId(mediaFeedData.getId());
                    if (instagramVideo != null) {
                        found = true;
                    } else {
                        instagramVideo = new InstagramVideo();
                        populateInstagramVideo(mediaFeedData, instagramVideo);

                        save(instagramVideo);
                    }
                }
            }
            if (!found && feed.getPagination().hasNextPage()) {
                logger.info("getting next page");
                feed = instagram.getTagMediaInfoNextPage(feed.getPagination());
                processFeed(feed);
            }
        }
    }

    @Transactional
    private void save(InstagramVideo instagramVideo) {
        instagramVideo.setInstagramUser(instagramUserDao.save(instagramVideo.getInstagramUser()));
        instagramVideoDao.save(instagramVideo);
    }

    private void populateInstagramVideo(MediaFeedData mediaFeedData, InstagramVideo instagramVideo) {
        instagramVideo.setInstagramId(mediaFeedData.getId());
        instagramVideo.setInstagramUrl(mediaFeedData.getLink());

        populatePart(mediaFeedData, instagramVideo);

        populateInstagramUser(mediaFeedData, instagramVideo);

        instagramVideo.setDate(new DateTime(1000 * Long.valueOf(mediaFeedData.getCreatedTime())));
        instagramVideo.setStatus(VideoStatus.NEW);
        instagramVideo.setUrl(mediaFeedData.getVideos().getStandardResolution().getUrl());
        instagramVideo.setPreloaderUrl(mediaFeedData.getImages().getStandardResolution().getImageUrl());
    }

    private void populatePart(MediaFeedData mediaFeedData, InstagramVideo instagramVideo) {
        List<String> tags = mediaFeedData.getTags();
        for (String tag: tags)
            if (tag.startsWith("part")) {
                try {
                    Long number = Long.valueOf(tag.substring(4));
                    instagramVideo.setPart(partsDao.findOne(number));
                } catch (Exception e) {

                }
            }
    }

    private void populateInstagramUser(MediaFeedData mediaFeedData, InstagramVideo instagramVideo) {
        instagramVideo.setInstagramUser(new InstagramUser());
        instagramVideo.getInstagramUser().setId(mediaFeedData.getUser().getId());
        instagramVideo.getInstagramUser().setFullName(mediaFeedData.getUser().getFullName());
        instagramVideo.getInstagramUser().setProfilePicture(mediaFeedData.getUser().getProfilePictureUrl());
        instagramVideo.getInstagramUser().setUserName(mediaFeedData.getUser().getUserName());
    }
}
