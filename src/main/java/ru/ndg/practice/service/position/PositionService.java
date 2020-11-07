package ru.ndg.practice.service.position;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.PositionView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface PositionService {

    List<PositionView> getAllPositions();
    PositionView getPosition(Integer id);
    void savePosition(@Valid PositionView position);
    void updatePosition(@Valid PositionView position);
}
