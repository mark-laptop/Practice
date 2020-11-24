package ru.ndg.practice.organization.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ndg.practice.controller.util.ControllerUtils;
import ru.ndg.practice.organization.service.OrganizationService;
import ru.ndg.practice.organization.view.OrganizationView;
import ru.ndg.practice.organization.view.transfer.OrganizationSave;
import ru.ndg.practice.organization.view.transfer.OrganizationUpdate;
import ru.ndg.practice.organization.view.transfer.OrganizationById;
import ru.ndg.practice.organization.view.transfer.OrganizationList;

import java.util.List;

@RestController
@RequestMapping(value = "/api/organization")
class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @JsonView(value = {OrganizationList.class})
    @GetMapping(value = {"/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllOrganizations(@RequestParam(required = false) MultiValueMap<String, String> params) {
        List<OrganizationView> listOrganization = organizationService.getAllOrganization(params);
        return new ResponseEntity<>(ControllerUtils.putViewInBody("data", listOrganization), HttpStatus.OK);
    }

    @JsonView(value = {OrganizationById.class})
    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrganizationById(@PathVariable(name = "id") Integer id) {
        OrganizationView organization = organizationService.getOrganization(id);
        return new ResponseEntity<>(ControllerUtils.putViewInBody("data", organization), HttpStatus.OK);
    }

    @PostMapping(value = {"/update"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateOrganization(@RequestBody @Validated(OrganizationUpdate.class) OrganizationView organizationView) {
        organizationService.updateOrganization(organizationView);
        return new ResponseEntity<>(ControllerUtils.putViewInBody("result", "success"), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = {"/save"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveOrganization(@RequestBody @Validated(OrganizationSave.class) OrganizationView organizationView) {
        organizationService.saveOrganization(organizationView);
        return new ResponseEntity<>(ControllerUtils.putViewInBody("result", "success"), HttpStatus.CREATED);
    }
}
