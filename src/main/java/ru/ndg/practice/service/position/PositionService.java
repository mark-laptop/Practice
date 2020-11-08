package ru.ndg.practice.service.position;

import ru.ndg.practice.view.PositionView;

import java.util.List;

public interface PositionService {

    List<PositionView> getAllPositions();
    PositionView getPosition(Integer id);
    void savePosition(PositionView position);
    void updatePosition(PositionView position);
}
