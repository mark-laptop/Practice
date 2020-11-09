package ru.ndg.practice.dao.documet_type;

import ru.ndg.practice.model.DocumentType;

import java.util.List;

public interface DocumentTypeDao {

    List<DocumentType> getAll();
    DocumentType getById(Integer id);
    DocumentType getByName(String name);
    DocumentType getByCode(Short code);
    void save(DocumentType documentType);
    void update(DocumentType documentType);
}
