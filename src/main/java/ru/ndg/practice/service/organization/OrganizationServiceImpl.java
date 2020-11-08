package ru.ndg.practice.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.dao.organization.OrganizationDao;
import ru.ndg.practice.model.Organization;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.OrganizationView;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> getAllOrganization(MultiValueMap<String, String> params) {
        List<Organization> listOrganizations = organizationDao.getAll(params);
        return mapperFacade.mapAsList(listOrganizations, OrganizationView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView getOrganization(Integer id) {
        Organization organizationEntity = organizationDao.getById(id);
        return mapperFacade.map(organizationEntity, OrganizationView.class);
    }

    @Override
    @Transactional
    public void saveOrganization(OrganizationView organization) {
        Organization organizationEntity = mapperFacade.map(organization, Organization.class);
        organizationDao.save(organizationEntity);
    }

    @Override
    @Transactional
    public void updateOrganization(OrganizationView organization) {
        Organization organizationEntity = mapperFacade.map(organization, Organization.class);
        organizationDao.update(organizationEntity);
    }
}
