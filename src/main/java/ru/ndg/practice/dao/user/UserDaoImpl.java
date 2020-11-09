package ru.ndg.practice.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.model.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAll(MultiValueMap<String, String> params) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> userCriteria = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = userCriteria.from(User.class);
        userCriteria.select(userRoot);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, List<String>> param : params.entrySet()) {
                userCriteria.where(userRoot.get(param.getKey()).in(param.getValue()));
            }
        }
        return entityManager.createQuery(userCriteria).getResultList();
    }

    @Override
    public User getById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> userCriteria = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = userCriteria.from(User.class);
        userCriteria.select(userRoot);
        userCriteria.where(criteriaBuilder.equal(userRoot.get("id"), id));
        return entityManager.createQuery(userCriteria).getSingleResult();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
