package ru.ndg.practice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.citizenship.dao.CitizenshipDao;
import ru.ndg.practice.document.dao.DocumentDao;
import ru.ndg.practice.office.dao.OfficeDao;
import ru.ndg.practice.position.dao.PositionDao;
import ru.ndg.practice.user.dao.UserDao;
import ru.ndg.practice.citizenship.model.Citizenship;
import ru.ndg.practice.document.model.Document;
import ru.ndg.practice.office.model.Office;
import ru.ndg.practice.position.model.Position;
import ru.ndg.practice.user.model.User;
import ru.ndg.practice.common.mapper.MapperFacade;
import ru.ndg.practice.user.view.UserView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Office office = officeDao.getById(user.getOfficeId());
        Position position = positionDao.getById(user.getPositionId());
        if (user.getCitizenshipCode() != null) {
            Citizenship citizenship = citizenshipDao.getByCode(user.getCitizenshipCode());
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
        User userEntity = userDao.getById(user.getId());
        mapperFacade.map(user, userEntity);
        Position position = positionDao.getById(user.getPositionId());
        if (user.getOfficeId() != null) {
            Office office = officeDao.getById(user.getOfficeId());
            userEntity.setOffice(office);
        }
        if (user.getCitizenshipCode() != null) {
            Citizenship citizenship = citizenshipDao.getByCode(user.getCitizenshipCode());
            userEntity.setCitizenship(citizenship);
        }
        if (documentParamExist(user)) {
            Document document = getDocument(user);
            userEntity.setDocument(document);
        }
        userEntity.setPosition(position);
    }

    private boolean documentParamExist(UserView userView) {
        return userView.getDocNumber() != null || userView.getDocDate() != null || userView.getDocCode() != null || userView.getDocName() != null;
    }

    private Document getDocument(UserView userView) {
        Map<String, Object> params = new HashMap<>();
        if (userView.getDocNumber() != null) {
            params.put("docNumber", userView.getDocNumber());
        }
        if (userView.getDocDate() != null) {
            params.put("docDate", userView.getDocDate());
        }
        if (userView.getDocName() != null) {
            params.put("docName", userView.getDocName());
        }
        if (userView.getDocCode() != null) {
            params.put("docCode", userView.getDocCode());
        }
        return documentDao.getByParam(params);
    }
}
