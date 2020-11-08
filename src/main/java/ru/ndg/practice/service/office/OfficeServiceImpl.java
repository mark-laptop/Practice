package ru.ndg.practice.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.dao.office.OfficeDao;
import ru.ndg.practice.model.Office;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.OfficeView;
import ru.ndg.practice.view.transfer.in.office.OfficeNew;
import ru.ndg.practice.view.transfer.in.office.OfficeUpdate;

import java.util.List;
import java.util.Set;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> getAllOffices(Set<Integer> ids) {
        List<Office> listOffices = officeDao.getAll(ids);
        return mapperFacade.mapAsList(listOffices, OfficeView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView getOffice(Integer id) {
        Office officeDaoEntity = officeDao.getById(id);
        return mapperFacade.map(officeDaoEntity, OfficeView.class);
    }

    @Override
    @Transactional
    public void saveOffice(@Validated(OfficeNew.class) OfficeView office) {
        Office officeEntity = mapperFacade.map(office, Office.class);
        officeDao.save(officeEntity);
    }

    @Override
    @Transactional
    public void updateOffice(@Validated(OfficeUpdate.class) OfficeView office) {
        Office officeEntity = mapperFacade.map(office, Office.class);
        officeDao.update(officeEntity);
    }
}
