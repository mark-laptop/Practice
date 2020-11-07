package ru.ndg.practice.controller.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.service.office.OfficeService;
import ru.ndg.practice.view.OfficeView;

import java.util.List;

@RestController
@RequestMapping(value = "/api/office")
class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping(value = {"/list"})
    public List<OfficeView> getAllOffices() {
        return officeService.getAllOffices();
    }

    @GetMapping(value = {"/{id}"})
    public OfficeView getOfficeById(@PathVariable(name = "id") Integer id) {
        return officeService.getOffice(id);
    }

    @PostMapping(value = {"/update"})
    public void updateOffice(@RequestBody OfficeView officeView) {
        officeService.updateOffice(officeView);
    }

    @PostMapping(value = {"/save"})
    public void saveOffice(@RequestBody OfficeView officeView) {
        officeService.saveOffice(officeView);
    }
}
