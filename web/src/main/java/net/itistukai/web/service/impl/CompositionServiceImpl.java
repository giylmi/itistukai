package net.itistukai.web.service.impl;

import net.itistukai.core.dao.CompositionDao;
import net.itistukai.core.dao.PartsDao;
import net.itistukai.core.domain.core.Composition;
import net.itistukai.core.domain.core.CompositionStatus;
import net.itistukai.core.domain.core.Part;
import net.itistukai.web.form.CompositionForm;
import net.itistukai.web.service.CompositionService;
import org.apache.commons.io.FileUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by giylmi on 03.03.2015.
 */
@Service
public class CompositionServiceImpl implements CompositionService {

    @Autowired
    CompositionDao compositionDao;
    @Autowired
    PartsDao partsDao;
    @Autowired
    Environment env;

    @Override
    public Boolean existsName(String name) {
        return !compositionDao.findAllByNameIgnoreCase(name).isEmpty();
    }

    @Override
    @Transactional
    public void saveComposition(CompositionForm compositionForm) {
        try {
            Composition composition = new Composition();
            composition.setName(compositionForm.getName());
            composition.setStatus(compositionForm.getStatus());
            composition = compositionDao.save(composition);

            saveParts(compositionForm, composition);

//            savePoster(compositionForm, composition);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void savePoster(CompositionForm compositionForm, Composition composition) throws IOException {
        String staticFolder = env.getProperty("static.folder");
        if (!staticFolder.endsWith(File.pathSeparator))
            staticFolder = staticFolder + File.pathSeparator;
        String uploadName = compositionForm.getPoster().getName();
        String extension = uploadName.substring(uploadName.lastIndexOf("."));
        File posterDirectory = new File(staticFolder + "poster");
        if (!posterDirectory.exists()) posterDirectory.mkdirs();
        File file = new File(posterDirectory.getAbsolutePath() + File.pathSeparator + composition.getId() + extension);
        FileUtils.copyInputStreamToFile(compositionForm.getPoster().getInputStream(), file);
    }

    public void saveParts(CompositionForm compositionForm, Composition composition) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(compositionForm.getFile().getInputStream()));
        String s = null;
        long n = 0;
        String text = "";
        int count = 0;
        while ((s = reader.readLine()) != null){
            s = s.trim();
            if (!s.isEmpty()) {
                count++;
                text = text + "\n" + s;
                if (count == 4) {
                    savePart(composition, ++n, text);
                    text = "";
                    count = 0;
                }
            }
        }
        if (!text.isEmpty()) {
            savePart(composition, n, text);
        }
    }

    public void savePart(Composition composition, long n, String text) {
        Part part = new Part();
        part.setNumber(n);
        part.setText(text);
        part.setComposition(composition);
        partsDao.save(part);
    }

    @Override
    public Long countOn() {
        return compositionDao.countByStatus(CompositionStatus.ON);
    }

    @Override
    public Long countArchived() {
        return compositionDao.countByStatus(CompositionStatus.ARCHIVED);
    }

    @Override
    @Transactional
    public Composition getOneByName(String s) {
        List<Composition> allByName = compositionDao.findAllByNameIgnoreCase(s);
        Hibernate.initialize(allByName.get(0).getParts());
        return allByName.get(0);
    }

    @Override
    public List<Composition> getAll() {
        return compositionDao.findAll();
    }
}
