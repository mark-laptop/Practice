package ru.ndg.practice.service.document;

import ru.ndg.practice.view.DocumentView;

import java.util.List;

public interface DocumentService {

    List<DocumentView> getAllDocuments();
    DocumentView getDocument(Integer id);
    void saveDocument(DocumentView document);
    void updateDocument(DocumentView document);
}
