package ru.ndg.practice.controller.organization;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.controller.DefaultController;
import ru.ndg.practice.service.organization.OrganizationService;
import ru.ndg.practice.view.OrganizationView;
import ru.ndg.practice.view.transfer.out.organization.OrganizationById;
import ru.ndg.practice.view.transfer.out.organization.OrganizationList;

import java.util.List;

@RestController
@RequestMapping(value = "/api/organization")
class OrganizationController implements DefaultController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @JsonView(value = {OrganizationList.class})
    @GetMapping(value = {"/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllOrganizations(
            @RequestParam(required = false) MultiValueMap<String, String> params) {
        List<OrganizationView> listOrganization = organizationService.getAllOrganization(params);
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
