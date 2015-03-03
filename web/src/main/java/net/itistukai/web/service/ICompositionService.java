package net.itistukai.web.service;

import net.itistukai.web.form.CompositionForm;

/**
 * Created by giylmi on 03.03.2015.
 */
public interface ICompositionService {

    public Boolean existsName(String name);

    void saveComposition(CompositionForm compositionForm);

    Long countOn();

    Long countArchived();
}
