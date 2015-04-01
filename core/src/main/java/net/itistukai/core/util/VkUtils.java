package net.itistukai.core.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by ainurminibaev on 01.04.15.
 */
public class VkUtils {

    public enum VideoType {
        Q_240("url240"),
        Q_360("url360"),
        Q_420("url420"),
        Q_760("url760");
        String key;

        VideoType(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public static String parseVideoUrl(String videoPhpUrl) {
        for (VideoType quality : VideoType.values()) {
            String url = parseVideoUrl(videoPhpUrl, quality);
            if (url != null) {
                return url;
            }
        }
        return null;
    }

    public static String parseVideoUrl(String videoPhpUrl, VideoType quality) {
        try {
            Connection.Response connection = Jsoup
                    .connect(videoPhpUrl).timeout(10 * 1000).execute();
            Document doc = connection.parse();
            Elements elementsByName = doc.getElementsByAttribute("name");
            for (Element e : elementsByName) {
                if (e.attr("name").equals("flashvars")) {
                    String value = e.attr("value");
                    String[] paramPairs = value.split("&");
                    for (int i = 0; i < paramPairs.length; i++) {
                        String pair = paramPairs[i];
                        if (pair.startsWith(quality.getKey())) {
                            System.out.println();
                            return pair.substring(quality.getKey().length() + 1);
                        }
                    }
                    System.out.println(value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
