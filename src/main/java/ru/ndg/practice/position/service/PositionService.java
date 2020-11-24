package ru.ndg.practice.position.service;

import ru.ndg.practice.position.view.PositionView;

import java.util.List;

public interface PositionService {

    List<PositionView> getAllPositions();
    PositionView getPosition(Integer id);
    void savePosition(PositionView position);
    void updatePosition(PositionView position);
}
