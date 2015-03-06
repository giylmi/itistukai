package net.itistukai.core.dao;

import net.itistukai.core.domain.core.Composition;
import net.itistukai.core.domain.core.CompositionStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by giylmi on 03.03.2015.
 */
public interface ICompositionDao {

    Long count();
    Long count(QueryParameters params);

    Composition save(Composition composition);

    public class QueryParameters {

        public List<CompositionStatus> withStatuses;

        public Map<String, Object> params;

        public QueryParameters(List<CompositionStatus> statuses, Map<String, Object> params) {
            this.withStatuses = statuses;
            this.params = params;
        }

        public Map<String, Object> asMap(){
            Map<String, Object> params = new HashMap<>();
            params.put("withStatuses", withStatuses);
            params.put("params", this.params);
            return params;
        }

        public static Builder builder(){
            return new Builder();
        }

        public static final class Builder {

            protected Builder(){}

            private List<CompositionStatus> statuses;
            private Map<String, Object> params = new HashMap<>();

            public List<CompositionStatus> getStatuses() {
                return statuses;
            }

            public Builder setStatuses(List<CompositionStatus> statuses) {
                this.statuses = statuses;
                return this;
            }

            public Builder addParam(String key, Object value){
                params.put(key, value);
                return this;
            }

            public QueryParameters build(){
                return new QueryParameters(statuses, params);
            }
        }
    }
}
