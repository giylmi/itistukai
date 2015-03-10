package net.itistukai.web.controller.admin;

import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.web.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        populateDashboard(model);
        return "admin/videos/videos";
    }

    public void populateDashboard(Model model) {
        model.addAttribute("newVideos", videosService.getNewVideosCount());
        model.addAttribute("viewedVideos", videosService.getViewedVideosCount());
        model.addAttribute("acceptedVideos", videosService.getAcceptedVideosCount());
        model.addAttribute("bannedVideos", videosService.getBannedVideosCount());
    }

    @RequestMapping(value = "videos/videos", method = RequestMethod.POST)
    public String videos(Model model, @RequestParam VideoStatus status, @RequestParam(required = false, defaultValue = "1") int page){
        List<Video> videosByStatus = videosService.getVideosByStatus(status, page);
        model.addAttribute("videos", videosByStatus);
        model.addAttribute("hasNext", videosByStatus.size() == 15);
        model.addAttribute("page", page + 1);
        populateDashboard(model);
        return "admin/videos/videosGridWrapper";
    }

    @RequestMapping(value = "videos/status", method = RequestMethod.POST)
    public String changeStatus(Model model, VideoStatus status, Long id) {
        Video video = videosService.getVideoById(id);
        if (video != null) {
            video.setStatus(status);
            video = videosService.saveVideo(video);
            model.addAttribute("video", video);
        }
        populateDashboard(model);
        return "admin/videos/videoStatusWrapper";
    }
}
