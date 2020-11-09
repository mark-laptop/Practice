package ru.ndg.practice.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.Application;
import ru.ndg.practice.service.organization.OrganizationService;
import ru.ndg.practice.view.OrganizationView;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
public class OrganizationDaoTest {

    private OrganizationService organizationService;

    @Autowired
    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Test
    public void getAllOrganizationWithOutParamTest() {
        List<OrganizationView> allOrganization = organizationService.getAllOrganization(null);
        Assert.assertNotNull(allOrganization);
        Assert.assertFalse(allOrganization.isEmpty());
    }

    @Test
    public void getAllOrganizationWithParamTest() {
        List<String> values = Collections.singletonList("123456789123");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("inn", values);
        List<OrganizationView> allOrganization = organizationService.getAllOrganization(params);
        Assert.assertNotNull(allOrganization);
        Assert.assertFalse(allOrganization.isEmpty());
    }

    @Test
    public void getOrganizationByIdTest() {
        Integer id = 1;
        OrganizationView organization = organizationService.getOrganization(id);
        Assert.assertNotNull(organization);
        Assert.assertEquals(organization.id, id);
    }

    @Test
    public void saveOrganizationTest() {

    }

    @Test
    public void updateOrganizationTest() {

    }
}
