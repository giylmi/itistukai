package net.itistukai.core;

import org.joda.time.DateTime;

/**
 * Created by giylmi on 03.03.2015.
 */
public interface Constants {

    public static DateTime START_DATE = DateTime.parse("2015-03-13");
    public static String MAIN_HASHTAG = "itistuqay";

    public static Integer VIDEOS_PAGE_SIZE = 15;
    public static final String REPLY_NODATA_PARAM = "noData";
    public static final Integer REPLY_PAGE_SIZE = 15;
    public static final String REPLIES_ATTR = "replies";
}
