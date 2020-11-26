package ru.ndg.practice.office.dao;

import ru.ndg.practice.office.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> getAll(Office office);
    Office getById(Integer id);
    void save(Office office);
    void update(Office office);
}
