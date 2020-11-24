package ru.ndg.practice.documenttype.dao;

import ru.ndg.practice.documenttype.model.DocumentType;

import java.util.List;
import java.util.Map;

public interface DocumentTypeDao {

    List<DocumentType> getAll();
    DocumentType getById(Integer id);
    DocumentType getByName(String name);
    DocumentType getByCode(Short code);
    DocumentType getByNameAndCode(Map<String, Object> params);
    void save(DocumentType documentType);
    void update(DocumentType documentType);
}
