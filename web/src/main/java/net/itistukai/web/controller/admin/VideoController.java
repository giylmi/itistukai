package net.itistukai.web.controller.admin;

import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.web.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by giylmi on 07.03.2015.
 */
@Controller
@RequestMapping("admin")
public class VideoController {

    @Autowired
    VideosService videosService;

    @RequestMapping("videos")
    public String dashboard(Model model, @RequestParam(required = false, defaultValue = "new") String tab){
        model.addAttribute("js_tab", tab);
        model.addAttribute("newVideos", videosService.getNewVideosCount());
        model.addAttribute("viewedVideos", videosService.getViewedVideosCount());
        model.addAttribute("acceptedVideos", videosService.getAcceptedVideosCount());
        model.addAttribute("bannedVideos", videosService.getBannedVideosCount());
        return "videos/videos";
    }

    @RequestMapping(value = "videos/videos", method = RequestMethod.POST)
    public String videos(Model model, @RequestParam VideoStatus status){
        model.addAttribute("videos", videosService.getVideosByStatus(status));
        return "videos/videosGrid";
    }
}
