package net.itistukai.core.domain.core;

import org.springframework.jdbc.core.RowMapper;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by giylmi on 26.12.14.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String salt;
    private String email;
    @Embedded
    private PersonalInformation pi;
    private UserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonalInformation getPi() {
        return pi;
    }

    public void setPi(PersonalInformation pi) {
        this.pi = pi;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public static RowMapper<User> COMMON_ROW = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setSalt(rs.getString("salt"));
            user.setEmail(rs.getString("email"));
            user.setRole(UserRole.byIntValue(rs.getInt("role")));
            return user;
        }
    };

    public static RowMapper<User> COMMON_WITH_PI_ROW = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = COMMON_ROW.mapRow(rs, rowNum);
            user.setPi(PersonalInformation.COMMON_ROW.mapRow(rs, rowNum));
            return user;
        }
    };

}
