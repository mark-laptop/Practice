package ru.ndg.practice.controller.office;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.controller.ControllerUtils;
import ru.ndg.practice.service.office.OfficeService;
import ru.ndg.practice.view.OfficeView;
import ru.ndg.practice.view.transfer.in.office.OfficeSave;
import ru.ndg.practice.view.transfer.in.office.OfficeUpdate;
import ru.ndg.practice.view.transfer.out.office.OfficeById;
import ru.ndg.practice.view.transfer.out.office.OfficeList;

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
    public ResponseEntity<Object> getAllOffices(@RequestParam(required = false) MultiValueMap<String, String> params) {
        List<OfficeView> listOffices = officeService.getAllOffices(params);
        return new ResponseEntity<>(ControllerUtils.putViewInBody("data", listOffices), HttpStatus.OK);
    }

    @JsonView(value = {OfficeById.class})
    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOfficeById(@PathVariable(name = "id") Integer id) {
        OfficeView office = officeService.getOffice(id);
        return new ResponseEntity<>(ControllerUtils.putViewInBody("data", office), HttpStatus.OK);
    }

    @PostMapping(value = {"/update"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateOffice(@RequestBody @Validated(OfficeUpdate.class) OfficeView officeView) {
        officeService.updateOffice(officeView);
        return new ResponseEntity<>(ControllerUtils.putViewInBody("result", "success"), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = {"/save"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveOffice(@RequestBody @Validated(OfficeSave.class) OfficeView officeView) {
        officeService.saveOffice(officeView);
        return new ResponseEntity<>(ControllerUtils.putViewInBody("result", "success"), HttpStatus.CREATED);
    }
}
