package ru.ndg.practice.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.OrganizationView;
import ru.ndg.practice.view.transfer.in.organization.OrganizationSave;
import ru.ndg.practice.view.transfer.in.organization.OrganizationUpdate;

import java.util.List;
import java.util.Set;

public interface OrganizationService {

    List<OrganizationView> getAllOrganization(Set<Integer> ids);
    OrganizationView getOrganization(Integer id);
    void saveOrganization(@Validated(OrganizationSave.class) OrganizationView organization);
    void updateOrganization(@Validated(OrganizationUpdate.class) OrganizationView organization);
}
