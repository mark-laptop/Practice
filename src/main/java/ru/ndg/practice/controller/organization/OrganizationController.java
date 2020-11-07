package ru.ndg.practice.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.service.organization.OrganizationService;
import ru.ndg.practice.view.OrganizationView;

import java.util.List;

@RestController
@RequestMapping(value = "/api/organization")
class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping(value = {"/list"})
    public List<OrganizationView> getAllOrganizations() {
        return organizationService.getAllOrganization();
    }

    @GetMapping(value = {"/{id}"})
    public OrganizationView getOrganizationById(@PathVariable(name = "id") Integer id) {
        return organizationService.getOrganization(id);
    }

    @PostMapping(value = {"/update"})
    public void updateOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.updateOrganization(organizationView);
    }

    @PostMapping(value = {"/save"})
    public void saveOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.saveOrganization(organizationView);
    }
}
