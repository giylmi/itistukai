package net.itistukai.core.dao;

import net.itistukai.core.domain.core.Composition;
import net.itistukai.core.domain.core.CompositionStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by giylmi on 03.03.2015.
 */
public interface CompositionDao extends PagingAndSortingRepository<Composition, Long> {

    @Override
    List<Composition> findAll();

    List<Composition> findAllByNameIgnoreCase(String name);

    Long countByStatus(CompositionStatus status);

    List<Composition> findAllByNameContainingIgnoreCase(String query);
}
