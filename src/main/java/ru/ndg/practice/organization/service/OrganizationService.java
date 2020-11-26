package ru.ndg.practice.organization.service;

import ru.ndg.practice.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService {

    List<OrganizationView> getAllOrganization(OrganizationView organization);
    OrganizationView getOrganization(Integer id);
    void saveOrganization(OrganizationView organization);
    void updateOrganization(OrganizationView organization);
}
