package ru.ndg.practice.office.service;

import org.springframework.util.MultiValueMap;
import ru.ndg.practice.office.view.OfficeView;

import java.util.List;

public interface OfficeService {

    List<OfficeView> getAllOffices(MultiValueMap<String, String> params);
    OfficeView getOffice(Integer id);
    void saveOffice(OfficeView office);
    void updateOffice(OfficeView office);
}
