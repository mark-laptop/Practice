package ru.ndg.practice.dao.user;

import ru.ndg.practice.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {

    List<User> getAll(Set<Integer> ids);
    User getById(Integer id);
    void save(User user);
    void update(User user);
}
