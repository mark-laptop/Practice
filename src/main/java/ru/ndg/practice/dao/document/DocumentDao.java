package ru.ndg.practice.dao.document;

import ru.ndg.practice.model.Document;

import java.util.Date;
import java.util.List;

public interface DocumentDao {

    List<Document> getAll();
    Document getById(Integer id);
    Document getByNumber(String number);
    void save(Document document);
    void update(Document document);
}
