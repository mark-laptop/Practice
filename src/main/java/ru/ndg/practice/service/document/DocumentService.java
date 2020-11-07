package ru.ndg.practice.service.document;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.DocumentView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface DocumentService {

    List<DocumentView> getAllDocuments();
    DocumentView getDocument(Integer id);
    void saveDocument(@Valid DocumentView document);
    void updateDocument(@Valid DocumentView document);
}
