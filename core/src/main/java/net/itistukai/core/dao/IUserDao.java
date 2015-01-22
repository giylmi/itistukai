package net.itistukai.core.dao;

import net.itistukai.core.domain.User;
import net.itistukai.core.domain.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by giylmi on 27.12.14.
 */
public interface IUserDao {

    List<User> all();

    List<User> all(UserQueryParameters params);

    User registerUser(User user);

    Integer count(UserQueryParameters parameters);

    Integer count();

    public class UserQueryParameters {

        public List<UserRole> withRoles;
        public Boolean withPI;

        private UserQueryParameters(){}

        public UserQueryParameters(List<UserRole> withRoles, Boolean withPI) {
            this.withRoles = withRoles;
            this.withPI = withPI;
        }

        public Map<String, Object> asMap(){
            Map<String, Object> params = new HashMap<>();
            params.put("withRoles", withRoles);
            params.put("withPI", withPI);
            return params;
        }

        public static Builder builder(){
            return new Builder();
        }

        public RowMapper<User> getMapper() {
            if (withPI != null && withPI) return User.COMMON_WITH_PI_ROW;
            return User.COMMON_ROW;
        }

        public static final class Builder {

            protected Builder(){}

            private List<UserRole> withRoles;
            private Boolean withPI;

            public Builder withRole(List<UserRole> withRoles){
                this.withRoles = withRoles;
                return this;
            }

            public Builder withPI(Boolean withPI){
                this.withPI = withPI;
                return this;
            }

            public UserQueryParameters build(){
                return new UserQueryParameters(withRoles, withPI);
            }
        }
    }
}
