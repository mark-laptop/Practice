package ru.ndg.practice.service.user;

import com.sun.istack.internal.Nullable;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.view.UserView;

import java.util.List;

public interface UserService {

    List<UserView> getAllUsers(@Nullable MultiValueMap<String, String> params);
    UserView getUser(Integer id);
    void saveUser(UserView user);
    void updateUser(UserView user);
}
