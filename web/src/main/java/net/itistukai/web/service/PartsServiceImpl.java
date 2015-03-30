package net.itistukai.web.service;

import net.itistukai.core.dao.PartsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by giylmi on 30.03.2015.
 */
@Service
public class PartsServiceImpl implements PartsService {

    @Autowired
    PartsDao partsDao;

    @Override
    public Long getReadPartsCount(Long id) {
        return partsDao.getReadPartsCount(id);
    }
}
