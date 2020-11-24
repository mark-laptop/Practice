package ru.ndg.practice.document.service;

import ru.ndg.practice.document.view.DocumentView;

import java.util.List;

public interface DocumentService {

    List<DocumentView> getAllDocuments();
    DocumentView getDocument(Integer id);
    void saveDocument(DocumentView document);
    void updateDocument(DocumentView document);
}
