package ru.ndg.practice.document.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ndg.practice.documenttype.dao.DocumentTypeDao;
import ru.ndg.practice.document.model.Document;
import ru.ndg.practice.documenttype.model.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager entityManager;
    private final DocumentTypeDao documentTypeDao;

    @Autowired
    public DocumentDaoImpl(EntityManager entityManager, DocumentTypeDao documentTypeDao) {
        this.entityManager = entityManager;
        this.documentTypeDao = documentTypeDao;
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
    public Document getByParam(Map<String, Object> params) {
        if (params == null || params.isEmpty()) throw new IllegalArgumentException("param not be null or empty");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Document> documentCriteria = criteriaBuilder.createQuery(Document.class);
        Root<Document> documentRoot = documentCriteria.from(Document.class);
        documentCriteria.select(documentRoot);
        documentCriteria.where(criteriaBuilder.equal(documentRoot.get("number"), params.get("docNumber")));
        documentCriteria.where(criteriaBuilder.equal(documentRoot.get("date"), params.get("docDate")));
        Document document = entityManager.createQuery(documentCriteria).getSingleResult();
        DocumentType documentType = documentTypeDao.getByNameAndCode(params);
        document.setDocumentType(documentType);
        return document;
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
