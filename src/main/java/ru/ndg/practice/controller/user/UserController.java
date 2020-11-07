package ru.ndg.practice.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.service.user.UserService;
import ru.ndg.practice.view.ResponseWrapperView;
import ru.ndg.practice.view.UserView;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/list"})
    public ResponseWrapperView<List<UserView>> getAllUsers() {
        List<UserView> allUsers = userService.getAllUsers();
        return new ResponseWrapperView<>(allUsers);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseWrapperView<UserView> getUserById(@PathVariable(name = "id") Integer id) {
        UserView user = userService.getUser(id);
        return new ResponseWrapperView<>(user);
    }

    @PostMapping(value = {"/update"})
    public ResponseWrapperView<String> updateUser(@RequestBody UserView userView) {
        userService.updateUser(userView);
        return new ResponseWrapperView<>("success");
    }

    @PostMapping(value = {"/save"})
    public ResponseWrapperView<String> saveUser(@RequestBody UserView userView) {
        userService.saveUser(userView);
        return new ResponseWrapperView<>("success");
    }
}
