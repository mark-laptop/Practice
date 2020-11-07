package ru.ndg.practice.service.document_type;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.DocumentTypeView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface DocumentTypeService {

    List<DocumentTypeView> getAllDocumentTypes();
    DocumentTypeView getDocumentType(Integer id);
    void saveDocumentType(@Valid DocumentTypeView documentType);
    void updateDocumentType(@Valid DocumentTypeView documentType);
}
