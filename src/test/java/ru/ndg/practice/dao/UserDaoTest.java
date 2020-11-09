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
import ru.ndg.practice.service.user.UserService;
import ru.ndg.practice.view.UserView;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
public class UserDaoTest {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void getAllUsersWithOutParamTest() {
        List<UserView> allUsers = userService.getAllUsers(null);
        Assert.assertNotNull(allUsers);
        Assert.assertFalse(allUsers.isEmpty());
    }

    @Test
    public void getAllUserWithParamTest() {
        List<String> values = Collections.singletonList("1");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("id", values);
        List<UserView> allUsers = userService.getAllUsers(params);
        Assert.assertNotNull(allUsers);
        Assert.assertFalse(allUsers.isEmpty());
    }

    @Test
    public void getUserByIdTest() {
        Integer id = 1;
        UserView user = userService.getUser(id);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.id, id);
    }

    @Test
    public void saveUserTest() {

    }

    @Test
    public void updateUserTest() {

    }
}
