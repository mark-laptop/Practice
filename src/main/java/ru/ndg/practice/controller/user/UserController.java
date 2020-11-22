package ru.ndg.practice.controller.user;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ndg.practice.service.user.UserService;
import ru.ndg.practice.view.UserView;
import ru.ndg.practice.view.transfer.in.user.UserSave;
import ru.ndg.practice.view.transfer.in.user.UserUpdate;
import ru.ndg.practice.view.transfer.out.user.UserById;
import ru.ndg.practice.view.transfer.out.user.UserList;

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
    public List<UserView> getAllUsers(@RequestParam(required = false) MultiValueMap<String, String> params) {
        return userService.getAllUsers(params);
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
