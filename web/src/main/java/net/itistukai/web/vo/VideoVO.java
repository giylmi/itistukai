package net.itistukai.web.vo;

/**
 * Created by adel on 09.04.15.
 */
public class VideoVO {

    private String url;
    private String preloaderUrl;
    private PartVO part;

    public VideoVO() {
    }

    public VideoVO(String url, String preloaderUrl, PartVO part) {

        this.url = url;
        this.preloaderUrl = preloaderUrl;
        this.part = part;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreloaderUrl() {
        return preloaderUrl;
    }

    public void setPreloaderUrl(String preloaderUrl) {
        this.preloaderUrl = preloaderUrl;
    }

    public PartVO getPart() {
        return part;
    }

    public void setPart(PartVO part) {
        this.part = part;
    }
}
