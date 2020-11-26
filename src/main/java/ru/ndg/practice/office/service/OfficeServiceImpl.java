package ru.ndg.practice.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ndg.practice.common.mapper.MapperFacade;
import ru.ndg.practice.office.dao.OfficeDao;
import ru.ndg.practice.office.model.Office;
import ru.ndg.practice.office.view.OfficeView;
import ru.ndg.practice.organization.dao.OrganizationDao;
import ru.ndg.practice.organization.model.Organization;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> getAllOffices(OfficeView office) {
        List<Office> listOffices = officeDao.getAll(mapperFacade.map(office, Office.class));
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
    public void saveOffice(OfficeView office) {
        Organization organization = organizationDao.getById(office.getOrgId());
        Office officeEntity = mapperFacade.map(office, Office.class);
        officeEntity.setOrganization(organization);
        officeDao.save(officeEntity);
    }

    @Override
    @Transactional
    public void updateOffice(OfficeView office) {
        Office officeEntity = officeDao.getById(office.getId());
        mapperFacade.map(office, officeEntity);
    }
}
