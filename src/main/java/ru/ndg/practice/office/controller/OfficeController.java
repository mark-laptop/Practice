package ru.ndg.practice.office.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ndg.practice.office.service.OfficeService;
import ru.ndg.practice.office.view.OfficeView;
import ru.ndg.practice.office.view.transfer.OfficeById;
import ru.ndg.practice.office.view.transfer.OfficeList;
import ru.ndg.practice.office.view.transfer.OfficeSave;
import ru.ndg.practice.office.view.transfer.OfficeUpdate;

import java.util.List;

@RestController
@RequestMapping(value = "/api/office")
class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @JsonView(value = {OfficeList.class})
    @GetMapping(value = {"/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OfficeView> getAllOffices(@Validated(OfficeList.class) OfficeView office) {
        return officeService.getAllOffices(office);
    }

    @JsonView(value = {OfficeById.class})
    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public OfficeView getOfficeById(@PathVariable(name = "id") Integer id) {
        return officeService.getOffice(id);
    }

    @PostMapping(value = {"/update"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOffice(@RequestBody @Validated(OfficeUpdate.class) OfficeView officeView) {
        officeService.updateOffice(officeView);
    }

    @PostMapping(value = {"/save"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOffice(@RequestBody @Validated(OfficeSave.class) OfficeView officeView) {
        officeService.saveOffice(officeView);
    }
}
