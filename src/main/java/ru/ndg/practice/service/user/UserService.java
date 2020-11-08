package ru.ndg.practice.service.user;

import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.UserView;
import ru.ndg.practice.view.transfer.in.user.UserSave;
import ru.ndg.practice.view.transfer.in.user.UserUpdate;

import java.util.List;

public interface UserService {

    List<UserView> getAllUsers(MultiValueMap<String, String> params);
    UserView getUser(Integer id);
    void saveUser(@Validated(UserSave.class) UserView user);
    void updateUser(@Validated(UserUpdate.class) UserView user);
}
