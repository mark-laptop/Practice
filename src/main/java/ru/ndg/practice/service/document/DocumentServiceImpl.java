package ru.ndg.practice.service.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ndg.practice.dao.document.DocumentDao;
import ru.ndg.practice.model.Document;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.DocumentView;

import javax.validation.Valid;
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
    public void saveDocument(@Valid DocumentView document) {
        Document documentEntity = mapperFacade.map(document, Document.class);
        documentDao.save(documentEntity);
    }

    @Override
    @Transactional
    public void updateDocument(@Valid DocumentView document) {
        Document documentEntity = mapperFacade.map(document, Document.class);
        documentDao.update(documentEntity);
    }
}
