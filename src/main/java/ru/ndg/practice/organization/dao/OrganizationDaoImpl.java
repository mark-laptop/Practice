package ru.ndg.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager entityManager;

    @Autowired
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Organization> getAll(MultiValueMap<String, String> params) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> organizationCriteria = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organizationRoot = organizationCriteria.from(Organization.class);
        organizationCriteria.select(organizationRoot);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, List<String>> param : params.entrySet()) {
                organizationCriteria.where(organizationRoot.get(param.getKey()).in(param.getValue()));
            }
        }
        return entityManager.createQuery(organizationCriteria).getResultList();
    }

    @Override
    public Organization getById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> organizationCriteria = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organizationRoot = organizationCriteria.from(Organization.class);
        organizationCriteria.select(organizationRoot);
        organizationCriteria.where(criteriaBuilder.equal(organizationRoot.get("id"), id));
        return entityManager.createQuery(organizationCriteria).getSingleResult();
    }

    @Override
    public void save(Organization organization) {
        entityManager.persist(organization);
    }

    @Override
    public void update(Organization organization) {
        entityManager.merge(organization);
    }
}
