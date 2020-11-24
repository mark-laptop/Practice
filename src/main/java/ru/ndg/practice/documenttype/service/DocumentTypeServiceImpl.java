package ru.ndg.practice.documenttype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ndg.practice.documenttype.dao.DocumentTypeDao;
import ru.ndg.practice.documenttype.model.DocumentType;
import ru.ndg.practice.config.mapper.MapperFacade;
import ru.ndg.practice.documenttype.view.DocumentTypeView;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeDao documentTypeDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDao documentTypeDao, MapperFacade mapperFacade) {
        this.documentTypeDao = documentTypeDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentTypeView> getAllDocumentTypes() {
        List<DocumentType> listDocumentTypes = documentTypeDao.getAll();
        return mapperFacade.mapAsList(listDocumentTypes, DocumentTypeView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentTypeView getDocumentType(Integer id) {
        DocumentType documentTypeEntity = documentTypeDao.getById(id);
        return mapperFacade.map(documentTypeEntity, DocumentTypeView.class);
    }

    @Override
    @Transactional
    public void saveDocumentType(DocumentTypeView documentType) {
        DocumentType documentEntity = mapperFacade.map(documentType, DocumentType.class);
        documentTypeDao.save(documentEntity);
    }

    @Override
    @Transactional
    public void updateDocumentType(DocumentTypeView documentType) {
        DocumentType documentEntity = mapperFacade.map(documentType, DocumentType.class);
        documentTypeDao.update(documentEntity);
    }
}
