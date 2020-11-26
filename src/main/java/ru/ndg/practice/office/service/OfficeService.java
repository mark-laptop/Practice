package ru.ndg.practice.office.service;

import ru.ndg.practice.office.view.OfficeView;

import java.util.List;

public interface OfficeService {

    List<OfficeView> getAllOffices(OfficeView office);
    OfficeView getOffice(Integer id);
    void saveOffice(OfficeView office);
    void updateOffice(OfficeView office);
}
