package ru.ndg.practice.service.citizenship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ndg.practice.dao.citizenship.CitizenshipDao;
import ru.ndg.practice.model.Citizenship;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.CitizenshipView;

import javax.validation.Valid;
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
    public void saveCitizenship(@Valid CitizenshipView citizenship) {
        Citizenship citizenshipEntity = mapperFacade.map(citizenship, Citizenship.class);
        citizenshipDao.save(citizenshipEntity);
    }

    @Override
    @Transactional
    public void updateCitizenship(@Valid CitizenshipView citizenship) {
        Citizenship citizenshipEntity = mapperFacade.map(citizenship, Citizenship.class);
        citizenshipDao.update(citizenshipEntity);
    }
}
