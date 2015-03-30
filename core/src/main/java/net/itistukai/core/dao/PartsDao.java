package net.itistukai.core.dao;

import net.itistukai.core.domain.core.Part;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by giylmi on 11.03.2015.
 */
public interface PartsDao extends CrudRepository<Part, Long> {
    List<Part> findAllByTextContainingIgnoreCase(String query);

    @Query(nativeQuery = true, value = "select count(distinct p.id) from part p right join video v on p.id=v.part_id where composition_id=?1")
    Long getReadPartsCount(Long compositionId);
}
