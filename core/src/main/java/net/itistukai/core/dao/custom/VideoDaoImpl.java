package net.itistukai.core.dao.custom;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by adel on 01.04.15.
 */
public class VideoDaoImpl implements VideoCustomDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public Page<Video> findGalleryVideosUniqueParted(VideoStatus status, Pageable pageable) {
        List<Long> ids = getLongIds();
        Order order1 = transformOrder(pageable);
        List videoList = getCurrentSession().createCriteria(Video.class).add(Restrictions.in("id", ids))
                .setMaxResults(pageable.getPageSize())
                .setFirstResult(pageable.getOffset())
                //it's magic - refactor so you can user sort on any child property not only part
                .createAlias("part", "part")
                .addOrder(order1)
                .list();
        long total = ((BigInteger) getCurrentSession().createSQLQuery("SELECT count(DISTINCT (part_id)) FROM video where part_id is not null").uniqueResult()).longValue();
        return new PageImpl<Video>(videoList, pageable, total);
    }

    private Order transformOrder(Pageable pageable) {
        Sort sort = pageable.getSort();
        Sort.Order order = sort.iterator().next();
        Order order1;
        if (order.isAscending())
            order1 = Order.asc(order.getProperty());
        else
            order1 = Order.desc(order.getProperty());
        return order1;
    }

    private List getLongIds() {
        return Lists.transform(getCurrentSession().createSQLQuery("SELECT DISTINCT ON (part_id) id FROM video  WHERE part_id IS NOT NULL AND status != 2 ORDER BY part_id, status DESC , random()").list(), new Function() {
            @Override
            public Long apply(Object input) {
                return ((BigInteger) input).longValue();
            }
        });
    }

    private Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }
}
