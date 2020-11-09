package ru.ndg.practice.dao.office;

import com.sun.istack.internal.Nullable;
import org.springframework.util.MultiValueMap;
import ru.ndg.practice.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> getAll(@Nullable MultiValueMap<String, String> params);
    Office getById(Integer id);
    void save(Office office);
    void update(Office office);
}
