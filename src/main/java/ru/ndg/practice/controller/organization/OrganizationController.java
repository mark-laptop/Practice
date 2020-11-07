package ru.ndg.practice.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.service.organization.OrganizationService;
import ru.ndg.practice.view.OrganizationView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/organization")
class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<Object> getAllOrganizations(@RequestParam(name = "id", required = false) Set<Integer> ids) {
        List<OrganizationView> listOrganization = organizationService.getAllOrganization(ids);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("data", listOrganization);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Object> getOrganizationById(@PathVariable(name = "id") Integer id) {
        OrganizationView organization = organizationService.getOrganization(id);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("data", organization);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping(value = {"/update"})
    public ResponseEntity<Object> updateOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.updateOrganization(organizationView);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("result", "success");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = {"/save"})
    public ResponseEntity<Object> saveOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.saveOrganization(organizationView);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("result", "success");
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
}
