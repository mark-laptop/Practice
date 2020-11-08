package ru.ndg.practice.service.document_type;

import ru.ndg.practice.view.DocumentTypeView;

import java.util.List;

public interface DocumentTypeService {

    List<DocumentTypeView> getAllDocumentTypes();
    DocumentTypeView getDocumentType(Integer id);
    void saveDocumentType(DocumentTypeView documentType);
    void updateDocumentType(DocumentTypeView documentType);
}
