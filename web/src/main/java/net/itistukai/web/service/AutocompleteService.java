package net.itistukai.web.service;

import net.itistukai.web.vo.CompositionVO;
import net.itistukai.web.vo.PartVO;

import java.util.List;

/**
 * Created by giylmi on 11.03.2015.
 */
public interface AutocompleteService {

    List<CompositionVO> autocompleteCompositions(String query);

    List<PartVO> autocompleteParts(String query, Long compositionId);
}
