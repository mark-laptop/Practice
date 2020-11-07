package ru.ndg.practice.controller.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.service.document.DocumentService;
import ru.ndg.practice.view.DocumentView;

import java.util.List;

@RestController
@RequestMapping(value = "/api/doc")
class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping(value = {"/list"})
    public List<DocumentView> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping(value = {"/{id}"})
    public DocumentView getDocument(@PathVariable(name = "id") Integer id) {
        return documentService.getDocument(id);
    }

    @PostMapping(value = {"/save"})
    public void saveDocument(@RequestBody DocumentView documentView) {
        documentService.saveDocument(documentView);
    }

    @PostMapping(value = {"/update"})
    public void updateDocument(@RequestBody DocumentView documentView) {
        documentService.updateDocument(documentView);
    }
}
