package ru.ndg.practice.organization.service;

import org.springframework.util.MultiValueMap;
import ru.ndg.practice.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService {

    List<OrganizationView> getAllOrganization(MultiValueMap<String, String> params);
    OrganizationView getOrganization(Integer id);
    void saveOrganization(OrganizationView organization);
    void updateOrganization(OrganizationView organization);
}
