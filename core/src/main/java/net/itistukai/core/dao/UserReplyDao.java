package net.itistukai.core.dao;

import net.itistukai.core.domain.core.UserReply;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by blvp on 31.03.15.
 */
public interface UserReplyDao extends PagingAndSortingRepository<UserReply, Long>{
    @Override
    List<UserReply> findAll();
}
