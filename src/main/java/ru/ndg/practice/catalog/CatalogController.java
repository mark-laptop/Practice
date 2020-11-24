package ru.ndg.practice.catalog;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ndg.practice.citizenship.service.CitizenshipService;
import ru.ndg.practice.citizenship.view.CitizenshipView;
import ru.ndg.practice.citizenship.view.transfer.CitizenshipCountries;
import ru.ndg.practice.documenttype.service.DocumentTypeService;
import ru.ndg.practice.documenttype.view.DocumentTypeView;
import ru.ndg.practice.documenttype.view.transfer.DocumentTypeDocs;

import java.util.List;

@RestController
@RequestMapping(value = {"/api"})
public class CatalogController {

    private final DocumentTypeService documentTypeService;
    private final CitizenshipService citizenshipService;

    @Autowired
    public CatalogController(DocumentTypeService documentTypeService, CitizenshipService citizenshipService) {
        this.documentTypeService = documentTypeService;
        this.citizenshipService = citizenshipService;
    }

    @JsonView(value = {DocumentTypeDocs.class})
    @GetMapping(value = {"/docs"})
    public List<DocumentTypeView> getAllDocuments() {
        return documentTypeService.getAllDocumentTypes();
    }

    @JsonView(value = {CitizenshipCountries.class})
    @GetMapping(value = {"/countries"})
    public List<CitizenshipView> getDocumentById() {
        return citizenshipService.getAllCitizenship();
    }
}
