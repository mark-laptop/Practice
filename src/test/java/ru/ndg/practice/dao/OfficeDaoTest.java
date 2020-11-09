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
import ru.ndg.practice.service.office.OfficeService;
import ru.ndg.practice.view.OfficeView;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
public class OfficeDaoTest {

    private OfficeService officeService;

    @Autowired
    public void setOfficeService(OfficeService officeService) {
        this.officeService = officeService;
    }

    @Test
    public void getAllOfficeWithOutParamTest() {
        List<OfficeView> allOffices = officeService.getAllOffices(null);
        Assert.assertNotNull(allOffices);
        Assert.assertFalse(allOffices.isEmpty());
    }

    @Test
    public void getAllOfficeWithParamTest() {
        List<String> values = Collections.singletonList("1");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("id", values);
        List<OfficeView> allOffices = officeService.getAllOffices(params);
        Assert.assertNotNull(allOffices);
        Assert.assertFalse(allOffices.isEmpty());
    }

    @Test
    public void getOfficeByIdTest() {
        Integer id = 1;
        OfficeView office = officeService.getOffice(id);
        Assert.assertNotNull(office);
        Assert.assertEquals(office.id, id);
    }

    @Test
    public void saveOfficeTest() {

    }

    @Test
    public void updateOfficeTest() {

    }
}
