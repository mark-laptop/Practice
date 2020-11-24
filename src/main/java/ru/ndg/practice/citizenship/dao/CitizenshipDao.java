package ru.ndg.practice.citizenship.dao;

import ru.ndg.practice.citizenship.model.Citizenship;

import java.util.List;

public interface CitizenshipDao {

    List<Citizenship> getAll();
    Citizenship getById(Integer id);
    Citizenship getByCode(Integer code);
    void save(Citizenship citizenship);
    void update(Citizenship citizenship);
}
