package ru.ndg.practice.controller.office;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.service.office.OfficeService;
import ru.ndg.practice.view.OfficeView;
import ru.ndg.practice.view.transfer.out.office.OfficeById;
import ru.ndg.practice.view.transfer.out.office.OfficeList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public ResponseEntity<Object> getAllOffices(@RequestParam(name = "id", required = false) Set<Integer> ids) {
        List<OfficeView> listOffices = officeService.getAllOffices(ids);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("data", listOffices);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @JsonView(value = {OfficeById.class})
    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOfficeById(@PathVariable(name = "id") Integer id) {
        OfficeView office = officeService.getOffice(id);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("data", office);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping(value = {"/update"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateOffice(@RequestBody OfficeView officeView) {
        officeService.updateOffice(officeView);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("result", "success");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = {"/save"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveOffice(@RequestBody OfficeView officeView) {
        officeService.saveOffice(officeView);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("result", "success");
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
}
