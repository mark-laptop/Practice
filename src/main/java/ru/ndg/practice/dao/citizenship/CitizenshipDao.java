package ru.ndg.practice.dao.citizenship;

import ru.ndg.practice.model.Citizenship;

import java.util.List;

public interface CitizenshipDao {

    List<Citizenship> getAll();
    Citizenship getById(Integer id);
    void save(Citizenship citizenship);
    void update(Citizenship citizenship);
}
