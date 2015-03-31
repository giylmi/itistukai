package net.itistukai.web.service;

import net.itistukai.core.domain.core.UserReply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by blvp on 31.03.15.
 */
public interface UserReplyService {
    Boolean hasAvailableDataToShow();

    Long countAll();

    Page<UserReply> getRepliesPage(Long page);

    Page<UserReply> getRepliesPage(Pageable pageable);

    Page<UserReply> getFirstPage();
}
