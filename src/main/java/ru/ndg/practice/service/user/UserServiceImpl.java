package ru.ndg.practice.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.dao.citizenship.CitizenshipDao;
import ru.ndg.practice.dao.document.DocumentDao;
import ru.ndg.practice.dao.office.OfficeDao;
import ru.ndg.practice.dao.position.PositionDao;
import ru.ndg.practice.dao.user.UserDao;
import ru.ndg.practice.model.*;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.UserView;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final OfficeDao officeDao;
    private final PositionDao positionDao;
    private final CitizenshipDao citizenshipDao;
    private final DocumentDao documentDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao userDao,
                           OfficeDao officeDao,
                           PositionDao positionDao,
                           CitizenshipDao citizenshipDao,
                           DocumentDao documentDao,
                           MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.positionDao = positionDao;
        this.citizenshipDao = citizenshipDao;
        this.documentDao = documentDao;
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
    public void saveUser(UserView user) {
        User userEntity = mapperFacade.map(user, User.class);
        Office office = officeDao.getById(user.officeId);
        Position position = positionDao.getById(user.positionId);
        if (user.citizenshipCode != null) {
            Citizenship citizenship = citizenshipDao.getByCode(user.citizenshipCode);
            userEntity.setCitizenship(citizenship);
        }
        if (documentParamExist(user)) {
            Document document = getDocument(user);
            userEntity.setDocument(document);
        }
        userEntity.setOffice(office);
        userEntity.setPosition(position);
        userDao.save(userEntity);
    }

    @Override
    @Transactional
    public void updateUser(UserView user) {
        User userEntity = userDao.getById(user.id);
        mapperFacade.map(user, userEntity);
        Position position = positionDao.getById(user.positionId);
        if (user.officeId != null) {
            Office office = officeDao.getById(user.officeId);
            userEntity.setOffice(office);
        }
        if (user.citizenshipCode != null) {
            Citizenship citizenship = citizenshipDao.getByCode(user.citizenshipCode);
            userEntity.setCitizenship(citizenship);
        }
        if (documentParamExist(user)) {
            Document document = getDocument(user);
            userEntity.setDocument(document);
        }
        userEntity.setPosition(position);
    }

    private boolean documentParamExist(UserView userView) {
        return userView.docNumber != null || userView.docDate != null || userView.docCode != null || userView.docName != null;
    }

    private Document getDocument(UserView userView) {
        return null;
    }
}
