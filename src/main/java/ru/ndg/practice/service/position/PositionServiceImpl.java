package ru.ndg.practice.service.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ndg.practice.dao.position.PositionDao;
import ru.ndg.practice.model.Position;
import ru.ndg.practice.model.mapper.MapperFacade;
import ru.ndg.practice.view.PositionView;

import javax.validation.Valid;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionDao positionDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public PositionServiceImpl(PositionDao positionDao, MapperFacade mapperFacade) {
        this.positionDao = positionDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PositionView> getAllPositions() {
        List<Position> listPositions = positionDao.getAll();
        return mapperFacade.mapAsList(listPositions, PositionView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PositionView getPosition(Integer id) {
        Position positionEntity = positionDao.getById(id);
        return mapperFacade.map(positionEntity, PositionView.class);
    }

    @Override
    @Transactional
    public void savePosition(@Valid PositionView position) {
        Position positionEntity = mapperFacade.map(position, Position.class);
        positionDao.save(positionEntity);
    }

    @Override
    @Transactional
    public void updatePosition(@Valid PositionView position) {
        Position positionEntity = mapperFacade.map(position, Position.class);
        positionDao.update(positionEntity);
    }
}
