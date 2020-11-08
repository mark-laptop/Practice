package ru.ndg.practice.controller.organization;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.controller.DefaultController;
import ru.ndg.practice.service.organization.OrganizationService;
import ru.ndg.practice.view.OrganizationView;
import ru.ndg.practice.view.transfer.out.organization.OrganizationById;
import ru.ndg.practice.view.transfer.out.organization.OrganizationList;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/organization")
class OrganizationController extends DefaultController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @JsonView(value = {OrganizationList.class})
    @GetMapping(value = {"/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllOrganizations(@RequestParam(name = "id", required = false) Set<Integer> ids) {
        List<OrganizationView> listOrganization = organizationService.getAllOrganization(ids);
        return new ResponseEntity<>(putViewInBody("data", listOrganization), HttpStatus.OK);
    }

    @JsonView(value = {OrganizationById.class})
    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrganizationById(@PathVariable(name = "id") Integer id) {
        OrganizationView organization = organizationService.getOrganization(id);
        return new ResponseEntity<>(putViewInBody("data", organization), HttpStatus.OK);
    }

    @PostMapping(value = {"/update"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.updateOrganization(organizationView);
        return new ResponseEntity<>(putViewInBody("result", "success"), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = {"/save"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.saveOrganization(organizationView);
        return new ResponseEntity<>(putViewInBody("result", "success"), HttpStatus.CREATED);
    }
}
