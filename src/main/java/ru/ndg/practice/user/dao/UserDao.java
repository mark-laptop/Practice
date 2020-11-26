package ru.ndg.practice.user.dao;

import ru.ndg.practice.user.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll(User user);
    User getById(Integer id);
    void save(User user);
    void update(User user);
}
