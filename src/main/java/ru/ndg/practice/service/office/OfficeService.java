package ru.ndg.practice.service.office;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.OfficeView;
import ru.ndg.practice.view.transfer.in.office.OfficeSave;
import ru.ndg.practice.view.transfer.in.office.OfficeUpdate;

import java.util.List;
import java.util.Set;

public interface OfficeService {

    List<OfficeView> getAllOffices(Set<Integer> orgId);
    OfficeView getOffice(Integer id);
    void saveOffice(@Validated(OfficeSave.class) OfficeView office);
    void updateOffice(@Validated(OfficeUpdate.class) OfficeView office);
}
