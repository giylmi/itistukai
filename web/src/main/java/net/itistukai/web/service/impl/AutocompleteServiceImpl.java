package net.itistukai.web.service.impl;

import net.itistukai.core.dao.ICompositionDao;
import net.itistukai.core.dao.PartsDao;
import net.itistukai.core.domain.core.Composition;
import net.itistukai.core.domain.core.Part;
import net.itistukai.web.service.AutocompleteService;
import net.itistukai.web.vo.CompositionVO;
import net.itistukai.web.vo.PartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by giylmi on 11.03.2015.
 */
@Service
public class AutocompleteServiceImpl implements AutocompleteService {

    @Autowired
    ICompositionDao compositionDao;
    @Autowired
    PartsDao partsDao;

    @Override
    public List<CompositionVO> autocompleteCompositions(String query) {
        List<Composition> compositions;
        if (query == null || query.isEmpty())
            compositions = (List<Composition>) compositionDao.findAll();
        else
            compositions = compositionDao.findAllByNameContaining(query);
        Collections.sort(compositions, Composition.BY_NAME_COMPARATOR);
        List<CompositionVO> vos = new ArrayList<>();
        for (Composition composition: compositions) {
            vos.add(mapComposition(composition));
        }
        return vos;
    }

    @Override
    public List<PartVO> autocompleteParts(String query, Long compositionId) {
        List<Part> parts;
        if (query == null || query.isEmpty())
            parts = (List<Part>) partsDao.findAll();
        else
            parts = partsDao.findAllByTextContaining(query);
        for(Iterator<Part> iterator = parts.iterator(); iterator.hasNext();){
            if (!iterator.next().getComposition().getId().equals(compositionId))
                iterator.remove();
        }
        Collections.sort(parts, Part.BY_NUMBER_COMPARATOR);
        List<PartVO> vos = new ArrayList<>();
        for (Part part: parts)
            vos.add(mapPart(part));
        return vos;
    }

    private PartVO mapPart(Part part) {
        return new PartVO(part.getId(), part.getText(), mapComposition(part.getComposition()));
    }

    private CompositionVO mapComposition(Composition composition) {
        return new CompositionVO(composition.getId(), composition.getName(), composition.getStatus());
    }
}
