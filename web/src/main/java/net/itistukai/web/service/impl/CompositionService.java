package net.itistukai.web.service.impl;

import net.itistukai.core.dao.ICompositionDao;
import net.itistukai.core.domain.core.Composition;
import net.itistukai.core.domain.core.CompositionStatus;
import net.itistukai.core.domain.core.Part;
import net.itistukai.web.form.CompositionForm;
import net.itistukai.web.service.ICompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by giylmi on 03.03.2015.
 */
@Service
public class CompositionService implements ICompositionService {

    @Autowired
    ICompositionDao compositionDao;

    @Override
    public Boolean existsName(String name) {
        return !compositionDao.findAllByName(name).isEmpty();
    }

    @Override
    @Transactional
    public void saveComposition(CompositionForm compositionForm) {
        try {
            Composition composition = new Composition();
            composition.setName(compositionForm.getName());
            composition.setStatus(compositionForm.getStatus());

            List<Part> parts = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(compositionForm.getFile().getInputStream()));
            String s = null;
            while ((s = reader.readLine()) != null){
                s = s.trim();
                if (!s.isEmpty()) {
                    Part part = new Part();
                    part.setText(s);
                    parts.add(part);
                }
            }
            composition.setParts(parts);

            compositionDao.save(composition);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Long countOn() {
        return compositionDao.countByStatus(CompositionStatus.ON);
    }

    @Override
    public Long countArchived() {
        return compositionDao.countByStatus(CompositionStatus.ARCHIVED);
    }
}
