package ru.ndg.practice.organization.dao;

import ru.ndg.practice.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {

    List<Organization> getAll(Organization organization);
    Organization getById(Integer id);
    void save(Organization organization);
    void update(Organization organization);
}
