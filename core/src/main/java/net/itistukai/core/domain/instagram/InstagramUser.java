package net.itistukai.core.domain.instagram;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by giylmi on 06.03.2015.
 */
@Entity
public class InstagramUser {

    @Id
    private String id;
    private String userName;
    private String profilePicture;
    private String fullName;

    @OneToMany(mappedBy = "id")
    private List<InstagramVideo> videos;

    public List<InstagramVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<InstagramVideo> videos) {
        this.videos = videos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
