package net.itistukai.core.domain.vk;

import net.itistukai.core.domain.core.Video;

import javax.persistence.*;

/**
 * Created by ainurminibaev on 28.03.15.
 */
@Entity
@Table(name = "vk_video")
@DiscriminatorValue("vk_video")
public class VkVideo extends Video {

    private Long vid;

    @ManyToOne
    @JoinColumn(name = "vk_owner_id", referencedColumnName = "id")
    private VkOwner vkOwner;

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public VkOwner getVkOwner() {
        return vkOwner;
    }

    public void setVkOwner(VkOwner vkOwner) {
        this.vkOwner = vkOwner;
    }
}
