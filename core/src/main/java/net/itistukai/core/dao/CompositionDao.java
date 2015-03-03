package net.itistukai.core.dao;

import com.google.common.collect.ImmutableMap;
import net.itistukai.core.dao.adapter.DataSourceAdapter;
import net.itistukai.core.dao.adapter.QueryManager;
import net.itistukai.core.domain.Composition;
import net.itistukai.core.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by giylmi on 03.03.2015.
 */
@Repository
public class CompositionDao implements ICompositionDao {

    @Autowired
    DataSourceAdapter ds;

    @Override
    public Long count() {
        return ds.query(QueryManager.getQuery("sql/composition/count.ftl"), new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                resultSet.next();
                return resultSet.getLong("count");
            }
        });
    }

    @Override
    public Long count(QueryParameters params) {
        return ds.query(QueryManager.getQuery("sql/composition/count.ftl", params.asMap()), new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                resultSet.next();
                return resultSet.getLong("count");
            }
        });
    }

    @Override
    public Composition save(Composition composition) {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        putIfNotNull(builder, "composition", composition);
        Map<String, Object> params = builder.build();
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        ds.update(QueryManager.getQuery("sql/composition/add.ftl", params), holder);
        Long id = ((Integer)holder.getKeys().get("id")).longValue();
        composition.setId(id);
        for (Part part: composition.getParts()){
            part.setCompositionId(id);
            ds.update(QueryManager.getQuery("sql/part/add.ftl", ImmutableMap.of("part", part)), holder);
            Long partId = ((Integer)holder.getKeys().get("id")).longValue();
            part.setId(partId);
        }
        return composition;
    }

    private ImmutableMap.Builder<String, Object> putIfNotNull(ImmutableMap.Builder builder, String key, Object value){
        if (value != null)
            builder.put(key, value);
        return builder;
    }
}
