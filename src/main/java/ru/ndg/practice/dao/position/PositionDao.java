package ru.ndg.practice.dao.position;

import ru.ndg.practice.model.Position;

import java.util.List;

public interface PositionDao {

    List<Position> getAll();
    Position getById(Integer id);
    void save(Position position);
    void update(Position position);
}
