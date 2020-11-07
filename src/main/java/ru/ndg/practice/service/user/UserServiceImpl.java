package ru.ndg.practice.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ndg.practice.dao.user.UserDao;
import ru.ndg.practice.model.User;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.UserView;

import javax.validation.Valid;
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
    public List<UserView> getAllUsers() {
        List<User> listUsers = userDao.getAll();
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
    public void saveUser(@Valid UserView user) {
        User userEntity = mapperFacade.map(user, User.class);
        userDao.save(userEntity);
    }

    @Override
    @Transactional
    public void updateUser(@Valid UserView user) {
        User userEntity = mapperFacade.map(user, User.class);
        userDao.update(userEntity);
    }
}
