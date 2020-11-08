package ru.ndg.practice.service.citizenship;

import ru.ndg.practice.view.CitizenshipView;

import java.util.List;

public interface CitizenshipService {

    List<CitizenshipView> getAllCitizenship();
    CitizenshipView getCitizenship(Integer id);
    void saveCitizenship(CitizenshipView citizenship);
    void updateCitizenship(CitizenshipView citizenship);
}
