package ru.ndg.practice.dao.citizenship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ndg.practice.model.Citizenship;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CitizenshipDaoImpl implements CitizenshipDao {

    private final EntityManager entityManager;

    @Autowired
    public CitizenshipDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Citizenship> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Citizenship> citizenshipCriteria = criteriaBuilder.createQuery(Citizenship.class);
        Root<Citizenship> citizenshipRoot = citizenshipCriteria.from(Citizenship.class);
        citizenshipCriteria.select(citizenshipRoot);
        return entityManager.createQuery(citizenshipCriteria).getResultList();
    }

    @Override
    public Citizenship getById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Citizenship> citizenshipCriteria = criteriaBuilder.createQuery(Citizenship.class);
        Root<Citizenship> citizenshipRoot = citizenshipCriteria.from(Citizenship.class);
        citizenshipCriteria.select(citizenshipRoot);
        citizenshipCriteria.where(criteriaBuilder.equal(citizenshipRoot.get("id"), id));
        return entityManager.createQuery(citizenshipCriteria).getSingleResult();
    }

    @Override
    public Citizenship getByCode(Integer code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Citizenship> citizenshipCriteria = criteriaBuilder.createQuery(Citizenship.class);
        Root<Citizenship> citizenshipRoot = citizenshipCriteria.from(Citizenship.class);
        citizenshipCriteria.select(citizenshipRoot);
        citizenshipCriteria.where(criteriaBuilder.equal(citizenshipRoot.get("code"), code));
        return entityManager.createQuery(citizenshipCriteria).getSingleResult();
    }

    @Override
    public void save(Citizenship citizenship) {
        entityManager.persist(citizenship);
    }

    @Override
    public void update(Citizenship citizenship) {
        entityManager.merge(citizenship);
    }
}
