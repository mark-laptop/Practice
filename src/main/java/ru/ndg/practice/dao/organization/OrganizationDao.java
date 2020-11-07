package ru.ndg.practice.dao.organization;

import ru.ndg.practice.model.Organization;

import java.util.List;

public interface OrganizationDao {

    List<Organization> getAll();
    Organization getById(Integer id);
    void save(Organization organization);
    void update(Organization organization);
}
