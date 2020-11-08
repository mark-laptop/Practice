package ru.ndg.practice.dao.organization;

import ru.ndg.practice.model.Organization;

import java.util.List;
import java.util.Set;

public interface OrganizationDao {

    List<Organization> getAll(Set<String> nameSet);
    Organization getById(Integer id);
    void save(Organization organization);
    void update(Organization organization);
}
