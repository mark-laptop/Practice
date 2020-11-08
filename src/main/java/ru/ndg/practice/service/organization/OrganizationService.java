package ru.ndg.practice.service.organization;

import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.OrganizationView;
import ru.ndg.practice.view.transfer.in.organization.OrganizationSave;
import ru.ndg.practice.view.transfer.in.organization.OrganizationUpdate;

import java.util.List;

public interface OrganizationService {

    List<OrganizationView> getAllOrganization(MultiValueMap<String, String> params);
    OrganizationView getOrganization(Integer id);
    void saveOrganization(@Validated(OrganizationSave.class) OrganizationView organization);
    void updateOrganization(@Validated(OrganizationUpdate.class) OrganizationView organization);
}
