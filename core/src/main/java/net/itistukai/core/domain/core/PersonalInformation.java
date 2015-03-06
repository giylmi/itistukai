package net.itistukai.core.domain.core;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by giylmi on 26.12.14.
 */
public class PersonalInformation {

    private Long userId;
    private String firstName;
    private String middleName;
    private String lastName;

    public PersonalInformation() {
    }

    public PersonalInformation(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static RowMapper<PersonalInformation> COMMON_ROW = new RowMapper<PersonalInformation>() {
       @Override
       public PersonalInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
           PersonalInformation pi = new PersonalInformation();
           pi.setFirstName(rs.getString("firstName"));
           pi.setLastName(rs.getString("lastName"));
           pi.setMiddleName(rs.getString("middleName"));
           return pi;
       }
    };

    public String toString(){
        return lastName + " " + firstName;
    }
}
