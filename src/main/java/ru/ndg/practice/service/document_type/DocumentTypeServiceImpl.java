package ru.ndg.practice.service.document_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ndg.practice.dao.documet_type.DocumentTypeDao;
import ru.ndg.practice.model.DocumentType;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.DocumentTypeView;

import javax.validation.Valid;
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
    public void saveDocumentType(@Valid DocumentTypeView documentType) {
        DocumentType documentEntity = mapperFacade.map(documentType, DocumentType.class);
        documentTypeDao.save(documentEntity);
    }

    @Override
    @Transactional
    public void updateDocumentType(@Valid DocumentTypeView documentType) {
        DocumentType documentEntity = mapperFacade.map(documentType, DocumentType.class);
        documentTypeDao.update(documentEntity);
    }
}
