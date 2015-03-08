package net.itistukai.core.dao;

import net.itistukai.core.domain.core.Composition;
import net.itistukai.core.domain.core.CompositionStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by giylmi on 03.03.2015.
 */
public interface ICompositionDao extends CrudRepository<Composition, Long> {

}
