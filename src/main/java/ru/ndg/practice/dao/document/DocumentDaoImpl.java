package ru.ndg.practice.dao.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ndg.practice.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager entityManager;

    @Autowired
    public DocumentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Document> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Document> documentCriteria = criteriaBuilder.createQuery(Document.class);
        Root<Document> documentRoot = documentCriteria.from(Document.class);
        documentCriteria.select(documentRoot);
        return entityManager.createQuery(documentCriteria).getResultList();
    }

    @Override
    public Document getById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Document> documentCriteria = criteriaBuilder.createQuery(Document.class);
        Root<Document> documentRoot = documentCriteria.from(Document.class);
        documentCriteria.select(documentRoot);
        documentCriteria.where(criteriaBuilder.equal(documentRoot.get("id"), id));
        return entityManager.createQuery(documentCriteria).getSingleResult();
    }

    @Override
    public Document getByNumber(String number) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Document> documentCriteria = criteriaBuilder.createQuery(Document.class);
        Root<Document> documentRoot = documentCriteria.from(Document.class);
        documentCriteria.select(documentRoot);
        documentCriteria.where(criteriaBuilder.equal(documentRoot.get("number"), number));
        return entityManager.createQuery(documentCriteria).getSingleResult();
    }

    @Override
    public void save(Document document) {
        entityManager.persist(document);
    }

    @Override
    public void update(Document document) {
        entityManager.merge(document);
    }
}
