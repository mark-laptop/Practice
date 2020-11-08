package ru.ndg.practice.service.user;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.UserView;
import ru.ndg.practice.view.transfer.in.user.UserSave;
import ru.ndg.practice.view.transfer.in.user.UserUpdate;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserView> getAllUsers(Set<Integer> officeId);
    UserView getUser(Integer id);
    void saveUser(@Validated(UserSave.class) UserView user);
    void updateUser(@Validated(UserUpdate.class) UserView user);
}
