package ru.ndg.practice.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.dao.user.UserDao;
import ru.ndg.practice.model.User;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.UserView;
import ru.ndg.practice.view.transfer.in.user.UserSave;
import ru.ndg.practice.view.transfer.in.user.UserUpdate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao userDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserView> getAllUsers(MultiValueMap<String, String> params) {
        List<User> listUsers = userDao.getAll(params);
        return mapperFacade.mapAsList(listUsers, UserView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public UserView getUser(Integer id) {
        User userEntity = userDao.getById(id);
        return mapperFacade.map(userEntity, UserView.class);
    }

    @Override
    @Transactional
    public void saveUser(@Validated(UserSave.class) UserView user) {
        User userEntity = mapperFacade.map(user, User.class);
        userDao.save(userEntity);
    }

    @Override
    @Transactional
    public void updateUser(@Validated(UserUpdate.class) UserView user) {
        User userEntity = mapperFacade.map(user, User.class);
        userDao.update(userEntity);
    }
}
