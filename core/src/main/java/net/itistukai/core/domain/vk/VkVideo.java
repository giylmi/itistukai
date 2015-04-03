package net.itistukai.core.domain.vk;

import net.itistukai.core.domain.core.Video;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ainurminibaev on 28.03.15.
 */
@Entity
@Table(name = "vk_video")
@DiscriminatorValue("vk_video")
public class VkVideo extends Video {

    private Long vid;

    @Column(name = "owner_id")
    private Long ownerId;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }
}
