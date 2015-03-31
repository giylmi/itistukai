package net.itistukai.web.controller.admin;

import net.itistukai.core.Constants;
import net.itistukai.core.domain.core.UserReply;
import net.itistukai.web.service.UserReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by blvp on 31.03.15.
 */
@Controller
@RequestMapping("admin")
public class UserReplyAdminController {

    @Autowired
    private UserReplyService replyService;



    @RequestMapping(value = "replies", method = RequestMethod.GET)
    public String renderReplyPageMain(Model model){
        model.addAttribute(Constants.REPLY_NODATA_PARAM, !replyService.hasAvailableDataToShow());
        return "admin/reply/replies";
    }
    @RequestMapping(value = "repliesMore", method = RequestMethod.GET)
    public String renderReplyMore(
            @RequestParam Long page,
            Model model, HttpSession session){
        Page<UserReply> repliesPage;

        if(page != null){
            repliesPage = replyService.getRepliesPage(page);
        } else {
            repliesPage = replyService.getFirstPage();
        }

        model.addAttribute(Constants.REPLIES_ATTR, repliesPage.getContent());

        if(repliesPage.getNumberOfElements() < Constants.REPLY_PAGE_SIZE){//to disable load more button
            model.addAttribute(Constants.REPLY_NODATA_PARAM, true);
        }

        return "admin/reply/replyTableData";

    }




}
