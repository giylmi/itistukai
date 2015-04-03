package net.itistukai.core;

import org.joda.time.DateTime;

/**
 * Created by giylmi on 03.03.2015.
 */
public interface Constants {

    DateTime START_DATE = DateTime.parse("2015-03-13");
    String MAIN_HASHTAG = "itistuqay";
    String TOKEN = "fca9b617f553119e0cd80f39e71f7ba48a065ef758af1bb3d57f125e2b774f18fc88d43925319b4bdf1fd";

    Integer VIDEOS_PAGE_SIZE = 15;


    String VK_API_PREFIX = "https://api.vk.com/method/";
}
