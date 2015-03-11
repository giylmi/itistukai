package net.itistukai.web.controller.api;

import net.itistukai.web.service.AutocompleteService;
import net.itistukai.web.vo.CompositionVO;
import net.itistukai.web.vo.PartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by giylmi on 11.03.2015.
 */
@Controller
@RequestMapping("autocomplete")
public class AutocompleteController {

    @Autowired
    AutocompleteService autocompleteService;

    @RequestMapping(value = "compositions", method = RequestMethod.POST)
    @ResponseBody
    public List<CompositionVO> compositionVOs(@RequestParam(defaultValue = "", required = false) String query){
        return autocompleteService.autocompleteCompositions(query);
    }

    @RequestMapping(value = "parts", method = RequestMethod.POST)
    @ResponseBody
    public List<PartVO> partVOs(@RequestParam(defaultValue = "", required = false) String query, @RequestParam(required = false) Long compositionId){
        return autocompleteService.autocompleteParts(query, compositionId);
    }
}
