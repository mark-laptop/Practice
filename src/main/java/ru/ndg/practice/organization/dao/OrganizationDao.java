package ru.ndg.practice.organization.dao;

import com.sun.istack.internal.Nullable;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {

    List<Organization> getAll(@Nullable MultiValueMap<String, String> params);
    Organization getById(Integer id);
    void save(Organization organization);
    void update(Organization organization);
}
