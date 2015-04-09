package net.itistukai.web.controller.site;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import net.itistukai.core.domain.core.Composition;
import net.itistukai.core.domain.core.Part;
import net.itistukai.core.domain.core.Video;
import net.itistukai.web.service.CompositionService;
import net.itistukai.web.service.PartsService;
import net.itistukai.web.service.VideosService;
import net.itistukai.web.sort.SortType;
import net.itistukai.web.vo.CompositionVO;
import net.itistukai.web.vo.PartVO;
import net.itistukai.web.vo.VideoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    PartsService partsService;

    @RequestMapping
    public String compositionPage(Model model,
                                  @RequestParam(required = false, defaultValue = "date_desc") SortType sort,
                                  @RequestParam(required = false, defaultValue = "grid") String viewType,
                                  @RequestParam(required = false, defaultValue = "false", value = "hideRepeat") String hideRepeatStr,
                                  @RequestParam(required = false) Long partId){
        Composition composition = compositionService.getTheOne();
        Part part = null;
        for (Part compositionPart: composition.getParts())
            if (compositionPart.getId().equals(partId)) {
                part = compositionPart;
                break;
            }
        model.addAttribute("readParts", partsService.getReadPartsCount(composition.getId()));
        model.addAttribute("composition", composition);
        model.addAttribute("sort", sort);
        model.addAttribute("viewType", viewType);
        model.addAttribute("js_compositionId", composition.getId());
        model.addAttribute("part", part);
        boolean hideRepeat = extractHideRepeat(hideRepeatStr);
        model.addAttribute("hideRepeat", hideRepeat);
        return "site/composition/composition";
    }

    @RequestMapping(value = "videos", method = RequestMethod.POST)
    public String videos(Model model,
                         @RequestParam(required = false, defaultValue = "date_desc") SortType sort,
                         @RequestParam(required = false, defaultValue = "grid") String viewType,
                         @RequestParam(required = false, defaultValue = "false", value = "hideRepeat") String hideRepeatStr,
                         @RequestParam(required = false) Long partId,
                         @RequestParam(required = false, defaultValue = "1") int page){
        boolean hideRepeat = extractHideRepeat(hideRepeatStr);
        Page galleryVideos = videosService.getGalleryVideos(page, partId, hideRepeat, sort);
        model.addAttribute("hasNext", galleryVideos.hasNext());
        model.addAttribute("page", page + 1);
        model.addAttribute("videos", galleryVideos.getContent());
        model.addAttribute("viewType", viewType);
        model.addAttribute("partId", partId);
        model.addAttribute("hideRepeat", hideRepeat);
        return "site/composition/videos";
    }

    @RequestMapping(value = "videos/json", method = RequestMethod.POST)
    @ResponseBody
    public List<VideoVO> videosJson(){
        List<Video> videos = videosService.getRandomMovie();
        return Lists.transform(videos, new Function<Video, VideoVO>() {
            @Override
            public VideoVO apply(Video input) {
                return new VideoVO(input.getUrl(), input.getPreloaderUrl(), getPart(input));
            }

            private PartVO getPart(Video input) {
                return new PartVO(input.getPart().getId(), input.getPart().getText(), getComposition(input));
            }

            private CompositionVO getComposition(Video input) {
                return new CompositionVO(input.getPart().getComposition().getId(), input.getPart().getComposition().getName(), input.getPart().getComposition().getStatus());
            }
        });
    }

    private boolean extractHideRepeat(String hideRepeatStr) {
        boolean hideRepeat;
        try {
            hideRepeat = Boolean.valueOf(hideRepeatStr);
        } catch (Exception e) { hideRepeat = false; }
        return hideRepeat;
    }
}
