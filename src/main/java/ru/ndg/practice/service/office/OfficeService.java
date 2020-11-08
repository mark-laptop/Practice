package ru.ndg.practice.service.office;

import org.springframework.util.MultiValueMap;
import ru.ndg.practice.view.OfficeView;

import java.util.List;

public interface OfficeService {

    List<OfficeView> getAllOffices(MultiValueMap<String, String> params);
    OfficeView getOffice(Integer id);
    void saveOffice(OfficeView office);
    void updateOffice(OfficeView office);
}
