package ru.ndg.practice.dao.document;

import ru.ndg.practice.model.Document;

import java.util.List;

public interface DocumentDao {

    List<Document> getAll();
    Document getById(Integer id);
    void save(Document document);
    void update(Document document);
}
