package ru.ndg.practice.dao.office;

import ru.ndg.practice.model.Office;

import java.util.List;
import java.util.Set;

public interface OfficeDao {

    List<Office> getAll(Set<Integer> ids);
    Office getById(Integer id);
    void save(Office office);
    void update(Office office);
}
