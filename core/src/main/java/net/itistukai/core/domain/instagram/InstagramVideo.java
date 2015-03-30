package net.itistukai.core.domain.instagram;

import net.itistukai.core.domain.core.Video;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by giylmi on 03.03.2015.
 */
@Entity
@DiscriminatorValue("INSTAGRAM")
public class InstagramVideo extends Video {
    private String instagramUrl;
    private String instagramId;
    @ManyToOne
    private InstagramUser instagramUser;

    public InstagramUser getInstagramUser() {
        return instagramUser;
    }

    public void setInstagramUser(InstagramUser instagramUser) {
        this.instagramUser = instagramUser;
    }

    public String getInstagramId() {
        return instagramId;
    }

    public void setInstagramId(String instagramId) {
        this.instagramId = instagramId;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }
}
