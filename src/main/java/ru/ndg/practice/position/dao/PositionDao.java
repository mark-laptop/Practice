package ru.ndg.practice.position.dao;

import ru.ndg.practice.position.model.Position;

import java.util.List;

public interface PositionDao {

    List<Position> getAll();
    Position getById(Integer id);
    void save(Position position);
    void update(Position position);
}
