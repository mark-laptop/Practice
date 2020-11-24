package ru.ndg.practice.user.service;

import com.sun.istack.internal.Nullable;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.user.view.UserView;

import java.util.List;

public interface UserService {

    List<UserView> getAllUsers(@Nullable MultiValueMap<String, String> params);
    UserView getUser(Integer id);
    void saveUser(UserView user);
    void updateUser(UserView user);
}
