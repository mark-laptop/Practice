package ru.ndg.practice.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ndg.practice.document.dao.DocumentDao;
import ru.ndg.practice.document.model.Document;
import ru.ndg.practice.common.mapper.MapperFacade;
import ru.ndg.practice.document.view.DocumentView;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public DocumentServiceImpl(DocumentDao documentDao, MapperFacade mapperFacade) {
        this.documentDao = documentDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentView> getAllDocuments() {
        List<Document> listDocuments = documentDao.getAll();
        return mapperFacade.mapAsList(listDocuments, DocumentView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentView getDocument(Integer id) {
        Document documentEntity = documentDao.getById(id);
        return mapperFacade.map(documentEntity, DocumentView.class);
    }

    @Override
    @Transactional
    public void saveDocument(DocumentView document) {
        Document documentEntity = mapperFacade.map(document, Document.class);
        documentDao.save(documentEntity);
    }

    @Override
    @Transactional
    public void updateDocument(DocumentView document) {
        Document documentEntity = mapperFacade.map(document, Document.class);
        documentDao.update(documentEntity);
    }
}
