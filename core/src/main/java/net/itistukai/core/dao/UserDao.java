package net.itistukai.core.dao;

import com.google.common.collect.ImmutableMap;
import net.itistukai.core.dao.adapter.DataSourceAdapter;
import net.itistukai.core.dao.adapter.QueryManager;
import net.itistukai.core.domain.core.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by giylmi on 27.12.14.
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    DataSourceAdapter ds;

    @Override
    public List<User> all() {
        return ds.query(QueryManager.getQuery("sql/user/all.ftl"), User.COMMON_ROW);
    }

    @Override
    public List<User> all(UserQueryParameters params) {
        String sql = QueryManager.getQuery("sql/user/all.ftl", params.asMap());
        return ds.query(sql, params.getMapper());
    }

    @Override
    public User registerUser(final User user) {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        putIfNotNull(builder, "login", user.getLogin());
        putIfNotNull(builder, "password", user.getPassword());
        putIfNotNull(builder, "salt", user.getSalt());
        putIfNotNull(builder, "email", user.getEmail());
        putIfNotNull(builder, "role", user.getRole().getValue());
        Map<String, Object> params = builder.build();
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        ds.update(QueryManager.getQuery("sql/user/add.ftl", params), holder);
        Long id = ((Integer)holder.getKeys().get("id")).longValue();
        user.setId(id);
        if (user.getPi() != null){
            user.getPi().setUserId(id);
            ds.execute(QueryManager.getQuery("sql/pi/add.ftl", ImmutableMap.of("pi", user.getPi())));
        }
        return user;
    }

    @Override
    public Integer count(UserQueryParameters parameters) {
        return ds.query(QueryManager.getQuery("sql/user/count.ftl", parameters.asMap()), new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                rs.next();
                return rs.getInt("count");
            }
        });
    }

    @Override
    public Integer count() {
        return ds.query(QueryManager.getQuery("sql/user/count.ftl"), new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                rs.next();
                return rs.getInt("count");
            }
        });
    }

    private ImmutableMap.Builder<String, Object> putIfNotNull(ImmutableMap.Builder builder, String key, Object value){
        if (value != null)
            builder.put(key, value);
        return builder;
    }
}
