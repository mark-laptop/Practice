package ru.ndg.practice.controller.user;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.controller.DefaultController;
import ru.ndg.practice.service.user.UserService;
import ru.ndg.practice.view.UserView;
import ru.ndg.practice.view.transfer.out.user.UserById;
import ru.ndg.practice.view.transfer.out.user.UserList;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/user")
class UserController implements DefaultController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @JsonView(value = {UserList.class})
    @GetMapping(value = {"/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllUsers(@RequestParam(required = false) MultiValueMap<String, String> params) {
        List<UserView> allUsers = userService.getAllUsers(params);
        return new ResponseEntity<>(putViewInBody("data", allUsers), HttpStatus.OK);
    }

    @JsonView(value = {UserById.class})
    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserById(@PathVariable(name = "id") Integer id) {
        UserView user = userService.getUser(id);
        return new ResponseEntity<>(putViewInBody("data", user), HttpStatus.OK);
    }

    @PostMapping(value = {"/update"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUser(@RequestBody UserView userView) {
        userService.updateUser(userView);
        return new ResponseEntity<>(putViewInBody("result", "success"), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = {"/save"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUser(@RequestBody UserView userView) {
        userService.saveUser(userView);
        return new ResponseEntity<>(putViewInBody("result", "success"), HttpStatus.CREATED);
    }
}
