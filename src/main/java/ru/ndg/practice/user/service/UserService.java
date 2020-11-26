package ru.ndg.practice.user.service;

import ru.ndg.practice.user.view.UserView;

import java.util.List;

public interface UserService {

    List<UserView> getAllUsers(UserView user);
    UserView getUser(Integer id);
    void saveUser(UserView user);
    void updateUser(UserView user);
}
