package ru.ndg.practice.documenttype.service;

import ru.ndg.practice.documenttype.view.DocumentTypeView;

import java.util.List;

public interface DocumentTypeService {

    List<DocumentTypeView> getAllDocumentTypes();
    DocumentTypeView getDocumentType(Integer id);
    void saveDocumentType(DocumentTypeView documentType);
    void updateDocumentType(DocumentTypeView documentType);
}
