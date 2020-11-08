package ru.ndg.practice.service.office;

import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.OfficeView;
import ru.ndg.practice.view.transfer.in.office.OfficeSave;
import ru.ndg.practice.view.transfer.in.office.OfficeUpdate;

import java.util.List;

public interface OfficeService {

    List<OfficeView> getAllOffices(MultiValueMap<String, String> params);
    OfficeView getOffice(Integer id);
    void saveOffice(@Validated(OfficeSave.class) OfficeView office);
    void updateOffice(@Validated(OfficeUpdate.class) OfficeView office);
}
