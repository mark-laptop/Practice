package ru.ndg.practice.service.office;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.OfficeView;
import ru.ndg.practice.view.transfer.office.OfficeNew;
import ru.ndg.practice.view.transfer.office.OfficeUpdate;

import java.util.List;
import java.util.Set;

public interface OfficeService {

    List<OfficeView> getAllOffices(Set<Integer> ids);
    OfficeView getOffice(Integer id);
    void saveOffice(@Validated(OfficeNew.class) OfficeView office);
    void updateOffice(@Validated(OfficeUpdate.class) OfficeView office);
}
