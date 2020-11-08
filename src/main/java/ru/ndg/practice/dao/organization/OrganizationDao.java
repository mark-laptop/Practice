package ru.ndg.practice.dao.organization;

import org.springframework.util.MultiValueMap;
import ru.ndg.practice.model.Organization;

import java.util.List;

public interface OrganizationDao {

    List<Organization> getAll(MultiValueMap<String, String> params);
    Organization getById(Integer id);
    void save(Organization organization);
    void update(Organization organization);
}
