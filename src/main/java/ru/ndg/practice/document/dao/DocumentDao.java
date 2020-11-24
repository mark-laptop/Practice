package ru.ndg.practice.document.dao;

import ru.ndg.practice.document.model.Document;

import java.util.List;
import java.util.Map;

public interface DocumentDao {

    List<Document> getAll();
    Document getById(Integer id);
    Document getByNumber(String number);
    Document getByParam(Map<String, Object> params);
    void save(Document document);
    void update(Document document);
}
