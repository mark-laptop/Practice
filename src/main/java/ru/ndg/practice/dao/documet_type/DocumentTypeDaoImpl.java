package ru.ndg.practice.dao.documet_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ndg.practice.model.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {

    private final EntityManager entityManager;

    @Autowired
    public DocumentTypeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<DocumentType> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DocumentType> documentTypeCriteria = criteriaBuilder.createQuery(DocumentType.class);
        Root<DocumentType> documentTypeRoot = documentTypeCriteria.from(DocumentType.class);
        documentTypeCriteria.select(documentTypeRoot);
        return entityManager.createQuery(documentTypeCriteria).getResultList();
    }

    @Override
    public DocumentType getById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DocumentType> documentTypeCriteria = criteriaBuilder.createQuery(DocumentType.class);
        Root<DocumentType> documentTypeRoot = documentTypeCriteria.from(DocumentType.class);
        documentTypeCriteria.select(documentTypeRoot);
        documentTypeCriteria.where(criteriaBuilder.equal(documentTypeRoot.get("id"), id));
        return entityManager.createQuery(documentTypeCriteria).getSingleResult();
    }

    @Override
    public void save(DocumentType documentType) {
        entityManager.persist(documentType);
    }

    @Override
    public void update(DocumentType documentType) {
        entityManager.merge(documentType);
    }
}
