package ru.ndg.practice.citizenship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ndg.practice.citizenship.dao.CitizenshipDao;
import ru.ndg.practice.citizenship.model.Citizenship;
import ru.ndg.practice.common.mapper.MapperFacade;
import ru.ndg.practice.citizenship.view.CitizenshipView;

import java.util.List;

@Service
public class CitizenshipServiceImpl implements CitizenshipService {

    private final CitizenshipDao citizenshipDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CitizenshipServiceImpl(CitizenshipDao citizenshipDao, MapperFacade mapperFacade) {
        this.citizenshipDao = citizenshipDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CitizenshipView> getAllCitizenship() {
        List<Citizenship> listCitizenship = citizenshipDao.getAll();
        return mapperFacade.mapAsList(listCitizenship, CitizenshipView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public CitizenshipView getCitizenship(Integer id) {
        Citizenship citizenshipEntity = citizenshipDao.getById(id);
        return mapperFacade.map(citizenshipEntity, CitizenshipView.class);
    }

    @Override
    @Transactional
    public void saveCitizenship(CitizenshipView citizenship) {
        Citizenship citizenshipEntity = mapperFacade.map(citizenship, Citizenship.class);
        citizenshipDao.save(citizenshipEntity);
    }

    @Override
    @Transactional
    public void updateCitizenship(CitizenshipView citizenship) {
        Citizenship citizenshipEntity = mapperFacade.map(citizenship, Citizenship.class);
        citizenshipDao.update(citizenshipEntity);
    }
}
