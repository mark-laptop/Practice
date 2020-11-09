package ru.ndg.practice.controller.catalog;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.controller.ControllerUtils;
import ru.ndg.practice.service.citizenship.CitizenshipService;
import ru.ndg.practice.service.document_type.DocumentTypeService;
import ru.ndg.practice.view.CitizenshipView;
import ru.ndg.practice.view.DocumentTypeView;
import ru.ndg.practice.view.transfer.out.citizanship.CitizenshipCountries;
import ru.ndg.practice.view.transfer.out.document_type.DocumentTypeDocs;

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
    public ResponseEntity<Object> getAllDocuments() {
        List<DocumentTypeView> allDocumentTypes = documentTypeService.getAllDocumentTypes();
        return new ResponseEntity<>(ControllerUtils.putViewInBody("docs", allDocumentTypes), HttpStatus.OK);
    }

    @JsonView(value = {CitizenshipCountries.class})
    @GetMapping(value = {"/countries"})
    public ResponseEntity<Object> getDocumentById() {
        List<CitizenshipView> allCitizenship = citizenshipService.getAllCitizenship();
        return new ResponseEntity<>(ControllerUtils.putViewInBody("countries", allCitizenship), HttpStatus.OK);
    }
}
