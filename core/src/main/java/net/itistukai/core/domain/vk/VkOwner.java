package net.itistukai.core.domain.vk;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ainurminibaev on 04.04.15.
 */
@Entity
@Table(name = "vk_owner")
public class VkOwner {

    @Id
    @SequenceGenerator(name = "vk_owner_generator", sequenceName = "vk_owner_seq")
    @GeneratedValue(generator = "vk_owner_generator")
    private Long id;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "owner_photo")
    private String ownerPhoto;

    @Column(name = "owner_name")
    private String ownerName;

    @OneToMany(mappedBy = "id")
    private List<VkVideo> userVideos;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerPhoto() {
        return ownerPhoto;
    }

    public void setOwnerPhoto(String ownerPhoto) {
        this.ownerPhoto = ownerPhoto;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLink() {
        if (ownerId == null) {
            return "";
        }
        if (ownerId < 0) {
            return "public" + ownerId * (-1);
        }
        return "id" + ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VkVideo> getUserVideos() {
        return userVideos;
    }

    public void setUserVideos(List<VkVideo> userVideos) {
        this.userVideos = userVideos;
    }
}
