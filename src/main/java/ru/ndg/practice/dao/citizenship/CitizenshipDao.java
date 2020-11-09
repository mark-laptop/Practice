package ru.ndg.practice.dao.citizenship;

import ru.ndg.practice.model.Citizenship;

import java.util.List;

public interface CitizenshipDao {

    List<Citizenship> getAll();
    Citizenship getById(Integer id);
    Citizenship getByCode(Integer code);
    void save(Citizenship citizenship);
    void update(Citizenship citizenship);
}
