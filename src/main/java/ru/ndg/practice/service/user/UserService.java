package ru.ndg.practice.service.user;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.UserView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Validated
public interface UserService {

    List<UserView> getAllUsers(Set<Integer> ids);
    UserView getUser(Integer id);
    void saveUser(@Valid UserView user);
    void updateUser(@Valid UserView user);
}
