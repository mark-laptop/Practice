package ru.ndg.practice.controller.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.service.document.DocumentService;
import ru.ndg.practice.service.user.UserService;
import ru.ndg.practice.view.DocumentView;
import ru.ndg.practice.view.UserView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"/api/doc"})
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<Object> getAllDocuments() {
        List<DocumentView> allDocuments = documentService.getAllDocuments();
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("data", allDocuments);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Object> getDocumentById(@PathVariable(name = "id") Integer id) {
        DocumentView document = documentService.getDocument(id);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("data", document);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping(value = {"/update"})
    public ResponseEntity<Object> updateDocument(@RequestBody DocumentView documentView) {
        documentService.updateDocument(documentView);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("result", "success");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = {"/save"})
    public ResponseEntity<Object> saveDocument(@RequestBody DocumentView documentView) {
        documentService.saveDocument(documentView);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("result", "success");
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
}
