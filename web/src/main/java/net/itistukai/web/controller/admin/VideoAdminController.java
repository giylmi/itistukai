package net.itistukai.web.controller.admin;

import net.itistukai.core.dao.PartsDao;
import net.itistukai.core.domain.core.Video;
import net.itistukai.core.domain.core.VideoStatus;
import net.itistukai.web.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by giylmi on 07.03.2015.
 */
@Controller
@RequestMapping("admin")
public class VideoAdminController {

    @Autowired
    VideosService videosService;
    @Autowired
    PartsDao partsDao;

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
        Page<Video> videosByStatus = videosService.getVideosByStatus(status, page);
        model.addAttribute("videos", videosByStatus.getContent());
        model.addAttribute("hasNext", videosByStatus.hasNext());
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

    @RequestMapping(value = "videos/{id}/edit", method = RequestMethod.GET)
    public String editVideo(Model model, @PathVariable Long id){
        Video video = videosService.getVideoById(id);
        model.addAttribute("video", video);
        return "admin/videos/videoPage";
    }
    @RequestMapping(value = "videos/{id}/edit", method = RequestMethod.POST)
    public String saveEditVideo(Model model, @PathVariable Long id, @RequestParam(required = false) Long partId, @RequestParam VideoStatus status){
        Video video = videosService.getVideoById(id);
        video.setStatus(status);
        video.setPart(partsDao.findOne(partId));
        video = videosService.saveVideo(video);
        model.addAttribute("video", video);
        model.addAttribute("saved", true);
        return "admin/videos/videoPage";
    }
}
