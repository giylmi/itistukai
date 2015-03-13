package net.itistukai.web.service;

import net.itistukai.core.domain.core.Composition;
import net.itistukai.web.form.CompositionForm;

/**
 * Created by giylmi on 03.03.2015.
 */
public interface CompositionService {

    public Boolean existsName(String name);

    void saveComposition(CompositionForm compositionForm);

    Long countOn();

    Long countArchived();

    Composition getOneByName(String s);
}
