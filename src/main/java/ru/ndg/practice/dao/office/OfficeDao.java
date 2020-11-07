package ru.ndg.practice.dao.office;

import ru.ndg.practice.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> getAll();
    Office getById(Integer id);
    void save(Office office);
    void update(Office office);
}
