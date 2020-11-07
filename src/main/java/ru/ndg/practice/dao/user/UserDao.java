package ru.ndg.practice.dao.user;

import ru.ndg.practice.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();
    User getById(Integer id);
    void save(User user);
    void update(User user);
}
