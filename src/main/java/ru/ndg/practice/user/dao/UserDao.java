package ru.ndg.practice.user.dao;

import org.springframework.util.MultiValueMap;
import ru.ndg.practice.user.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll(MultiValueMap<String, String> params);
    User getById(Integer id);
    void save(User user);
    void update(User user);
}
