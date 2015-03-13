package net.itistukai.web.controller.site;

import net.itistukai.core.domain.core.Video;
import net.itistukai.web.service.CompositionService;
import net.itistukai.web.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by adel on 12.03.15.
 */
@Controller
@RequestMapping("composition")
public class CompositionPageController {

    @Autowired
    CompositionService compositionService;
    @Autowired
    VideosService videosService;

    @RequestMapping
    public String compositionPage(Model model){
        model.addAttribute("composition", compositionService.getOneByName("The Shuraleh"));

        return "site/composition/composition";
    }

    @RequestMapping(value = "videos", method = RequestMethod.POST)
    public String videos(Model model,
                         @RequestParam(required = false, defaultValue = "date") String sort,
                         @RequestParam(required = false, defaultValue = "") String query,
                         @RequestParam(required = false, defaultValue = "grid") String viewType,
                         @RequestParam(required = false, defaultValue = "1") int page){
        Page galleryVideos = videosService.getGalleryVideos(page);
        model.addAttribute("hasNext", galleryVideos.hasNext());
        model.addAttribute("page", page + 1);
        model.addAttribute("videos", galleryVideos.getContent());
        return "site/composition/videos";
    }
}
