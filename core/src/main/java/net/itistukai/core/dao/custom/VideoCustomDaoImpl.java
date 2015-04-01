package net.itistukai.core.dao.custom;

import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

/**
 * Created by adel on 01.04.15.
 */
@Repository
public class VideoCustomDaoImpl implements VideoCustomDao {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public Page<Video> findAllByStatusNotGroupByPartId(VideoStatus status, Pageable pageable) {
        getCurrentSession().createSQLQuery(
                "select * from (select *, ROW_NUMBER() OVER (PARTITION BY part_id ORDER BY status desc, RANDOM()) as rn from video " +
                        "where status != 2 and part_id is not null) v where v.rn=1 order by date limit :limit offset :offset")
                .setParameter("limit", pageable.getPageSize())
                .setParameter("offset", pageable.getOffset());
        return null;
    }

    private Session getCurrentSession() {
        return entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
    }
}
