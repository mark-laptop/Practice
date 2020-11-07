package ru.ndg.practice.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.OrganizationView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {

    List<OrganizationView> getAllOrganization();
    OrganizationView getOrganization(Integer id);
    void saveOrganization(@Valid OrganizationView organization);
    void updateOrganization(@Valid OrganizationView organization);
}
