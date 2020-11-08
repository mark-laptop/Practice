package ru.ndg.practice.service.user;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.UserView;
import ru.ndg.practice.view.transfer.user.UserNew;
import ru.ndg.practice.view.transfer.user.UserUpdate;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserView> getAllUsers(Set<Integer> ids);
    UserView getUser(Integer id);
    void saveUser(@Validated(UserNew.class) UserView user);
    void updateUser(@Validated(UserUpdate.class) UserView user);
}
