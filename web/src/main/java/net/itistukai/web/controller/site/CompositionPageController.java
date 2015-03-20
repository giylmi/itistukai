package net.itistukai.web.controller.site;

import net.itistukai.core.domain.core.Composition;
import net.itistukai.core.domain.core.Part;
import net.itistukai.web.service.CompositionService;
import net.itistukai.web.service.VideosService;
import net.itistukai.web.sort.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String compositionPage(Model model,
                                  @RequestParam(required = false, defaultValue = "date_desc") SortType sort,
                                  @RequestParam(required = false, defaultValue = "grid") String viewType,
                                  @RequestParam(required = false) Long partId){
        Composition composition = compositionService.getAll().get(0);
        Part part = null;
        for (Part compositionPart: composition.getParts())
            if (compositionPart.getId().equals(partId)) {
                part = compositionPart;
                break;
            }
        model.addAttribute("composition", composition);
        model.addAttribute("sort", sort);
        model.addAttribute("viewType", viewType);
        model.addAttribute("js_compositionId", composition.getId());
        model.addAttribute("part", part);
        return "site/composition/composition";
    }

    @RequestMapping(value = "videos", method = RequestMethod.POST)
    public String videos(Model model,
                         @RequestParam(required = false, defaultValue = "date_desc") SortType sort,
                         @RequestParam(required = false, defaultValue = "grid") String viewType,
                         @RequestParam(required = false) Long partId,
                         @RequestParam(required = false, defaultValue = "1") int page){
        Page galleryVideos = videosService.getGalleryVideos(page, partId, sort);
        model.addAttribute("hasNext", galleryVideos.hasNext());
        model.addAttribute("page", page + 1);
        model.addAttribute("videos", galleryVideos.getContent());
        model.addAttribute("viewType", viewType);
        model.addAttribute("partId", partId);
        return "site/composition/videos";
    }
}
