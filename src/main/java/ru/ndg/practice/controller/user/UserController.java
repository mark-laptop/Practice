package ru.ndg.practice.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.service.user.UserService;
import ru.ndg.practice.view.UserView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/user")
class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<Object> getAllUsers() {
        List<UserView> allUsers = userService.getAllUsers();
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("data", allUsers);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Object> getUserById(@PathVariable(name = "id") Integer id) {
        UserView user = userService.getUser(id);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("data", user);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping(value = {"/update"})
    public ResponseEntity<Object> updateUser(@RequestBody UserView userView) {
        userService.updateUser(userView);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("result", "success");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = {"/save"})
    public ResponseEntity<Object> saveUser(@RequestBody UserView userView) {
        userService.saveUser(userView);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("result", "success");
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
}
