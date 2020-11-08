package ru.ndg.practice.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.dao.organization.OrganizationDao;
import ru.ndg.practice.model.Organization;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.OrganizationView;
import ru.ndg.practice.view.transfer.organization.OrganizationNew;
import ru.ndg.practice.view.transfer.organization.OrganizationUpdate;

import java.util.List;
import java.util.Set;

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
    public List<OrganizationView> getAllOrganization(Set<Integer> ids) {
        List<Organization> listOrganizations = organizationDao.getAll(ids);
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
    public void saveOrganization(@Validated(OrganizationNew.class) OrganizationView organization) {
        Organization organizationEntity = mapperFacade.map(organization, Organization.class);
        organizationDao.save(organizationEntity);
    }

    @Override
    @Transactional
    public void updateOrganization(@Validated(OrganizationUpdate.class) OrganizationView organization) {
        Organization organizationEntity = mapperFacade.map(organization, Organization.class);
        organizationDao.update(organizationEntity);
    }
}
