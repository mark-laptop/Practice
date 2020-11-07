package ru.ndg.practice.dao.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ndg.practice.model.Position;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao {

    private final EntityManager entityManager;

    @Autowired
    public PositionDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Position> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Position> positionCriteria = criteriaBuilder.createQuery(Position.class);
        Root<Position> positionRoot = positionCriteria.from(Position.class);
        positionCriteria.select(positionRoot);
        return entityManager.createQuery(positionCriteria).getResultList();
    }

    @Override
    public Position getById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Position> positionCriteria = criteriaBuilder.createQuery(Position.class);
        Root<Position> positionRoot = positionCriteria.from(Position.class);
        positionCriteria.select(positionRoot);
        positionCriteria.where(criteriaBuilder.equal(positionRoot.get("id"), id));
        return entityManager.createQuery(positionCriteria).getSingleResult();
    }

    @Override
    public void save(Position position) {
        entityManager.persist(position);
    }

    @Override
    public void update(Position position) {
        entityManager.merge(position);
    }
}
