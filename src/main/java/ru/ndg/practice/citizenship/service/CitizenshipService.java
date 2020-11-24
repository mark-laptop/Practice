package ru.ndg.practice.citizenship.service;

import ru.ndg.practice.citizenship.view.CitizenshipView;

import java.util.List;

public interface CitizenshipService {

    List<CitizenshipView> getAllCitizenship();
    CitizenshipView getCitizenship(Integer id);
    void saveCitizenship(CitizenshipView citizenship);
    void updateCitizenship(CitizenshipView citizenship);
}
