package net.itistukai.web.service.impl;

import net.itistukai.core.Constants;
import net.itistukai.core.dao.UserReplyDao;
import net.itistukai.core.domain.core.UserReply;
import net.itistukai.web.service.UserReplyService;
import net.itistukai.web.sort.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by blvp on 31.03.15.
 */
@Service
public class UserReplyServiceImpl implements UserReplyService {
    @Autowired
    private UserReplyDao replyDao;

    @Override
    public Boolean hasAvailableDataToShow() {
        return countAll() != 0;
    }

    @Override
    public Long countAll() {
        return replyDao.count();
    }

    @Override
    public Page<UserReply> getRepliesPage(Long page) {
        PageRequest pageReq = new PageRequest(page.intValue(),Constants.REPLY_PAGE_SIZE);
        return replyDao.findAll(pageReq);
    }

    @Override
    public Page<UserReply> getRepliesPage(Pageable pageable) {
        return replyDao.findAll(pageable);
    }

    @Override
    public Page<UserReply> getFirstPage() {
        return getRepliesPage(0L);
    }
}
