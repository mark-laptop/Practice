package ru.ndg.practice.service.citizenship;

import org.springframework.validation.annotation.Validated;
import ru.ndg.practice.view.CitizenshipView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface CitizenshipService {

    List<CitizenshipView> getAllCitizenship();
    CitizenshipView getCitizenship(Integer id);
    void saveCitizenship(@Valid CitizenshipView citizenship);
    void updateCitizenship(@Valid CitizenshipView citizenship);
}
