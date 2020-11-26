package ru.ndg.practice.user.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ndg.practice.user.service.UserService;
import ru.ndg.practice.user.view.UserView;
import ru.ndg.practice.user.view.transfer.UserById;
import ru.ndg.practice.user.view.transfer.UserList;
import ru.ndg.practice.user.view.transfer.UserSave;
import ru.ndg.practice.user.view.transfer.UserUpdate;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @JsonView(value = {UserList.class})
    @GetMapping(value = {"/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserView> getAllUsers(@Validated(UserList.class) UserView user) {
        return userService.getAllUsers(user);
    }

    @JsonView(value = {UserById.class})
    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView getUserById(@PathVariable(name = "id") Integer id) {
        return userService.getUser(id);
    }

    @PostMapping(value = {"/update"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody @Validated(UserUpdate.class) UserView userView) {
        userService.updateUser(userView);
    }

    @PostMapping(value = {"/save"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveUser(@RequestBody @Validated(UserSave.class) UserView userView) {
        userService.saveUser(userView);
    }
}
