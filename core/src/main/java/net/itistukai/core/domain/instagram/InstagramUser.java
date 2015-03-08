package net.itistukai.core.domain.instagram;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by giylmi on 06.03.2015.
 */
public class InstagramUser {

    public static RowMapper<InstagramUser> FULL_ROW_MAPPER = new RowMapper<InstagramUser>() {
        @Override
        public InstagramUser mapRow(ResultSet resultSet, int i) throws SQLException {
            InstagramUser instagramUser = new InstagramUser();
            instagramUser.setUserName(resultSet.getString("username"));
            instagramUser.setFullName(resultSet.getString("full_name"));
            instagramUser.setProfilePicture(resultSet.getString("profile_picture"));
            instagramUser.setId(resultSet.getString("user_id"));
            return instagramUser;
        }
    };
    private String id;
    private String userName;
    private String profilePicture;
    private String fullName;

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
