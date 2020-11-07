package ru.ndg.practice.service.office;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.OfficeView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Validated
public interface OfficeService {

    List<OfficeView> getAllOffices(Set<Integer> ids);
    OfficeView getOffice(Integer id);
    void saveOffice(@Valid OfficeView office);
    void updateOffice(@Valid OfficeView office);
}
